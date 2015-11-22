package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.guiController.AddToConsoleController;
import controller.guiController.ControlAddPointPolygone;
import controller.guiController.ControlAddPointPolyline;
import controller.guiController.ControlCircleRadioBtn;
import controller.guiController.ControlEllipseRadioBtn;
import controller.guiController.ControlFillNoRadioBtn;
import controller.guiController.ControlFillYesRadioBtn;
import controller.guiController.ControlLineRadioBtn;
import controller.guiController.ControlPolygoneRadioBtn;
import controller.guiController.ControlPolylineRadioBtn;
import controller.guiController.ControlRectangleRadioBtn;
import controller.guiController.ControlRunGUI;
import controller.guiController.ControlSaveSVGImg;
import controller.guiController.ControlTextRadioBtn;
import model.ColorRBG;
import model.Pencil;
import model.Shape;
import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import model.specific_path.Polygon;
import model.specific_path.Polyline;
import model.specific_path.Rectangle;
import model.specific_path.Text;

/*
 * this class creates the graphical user interface for the svg drawing
 */
public class GUI extends JFrame{

	private Circle circleModele;
	private Ellipse ellipseModele;
	private Line lineModele;
	private Polygon polygoneModele;
	private Polyline polylineModele;
	private Rectangle rectangleModele;
	private Text textModele;
	
	private ColorRBG pencilColor;
	private ColorRBG fillColor;
	private Pencil pencil;
	
	private ArrayList<JComponent> toHide = new ArrayList<JComponent>();
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();

	private static final long serialVersionUID = 7101648530122179966L;

	public GUI(){
		super("Drawing interface");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//create the models
		this.circleModele = new Circle();
		this.ellipseModele = new Ellipse();
		this.lineModele = new Line();
		this.polygoneModele = new Polygon();
		this.polygoneModele.setPoints(new ArrayList<Point>());
		this.polylineModele = new Polyline();
		this.polylineModele.setPoints(new ArrayList<Point>());
		this.rectangleModele = new Rectangle();
		this.textModele = new Text();
		
		//style
		this.pencilColor = new ColorRBG(Color.BLACK.getRGB());
		this.fillColor = new ColorRBG(Color.WHITE.getRGB());
		//default values for the pencil : black and width 4
		this.pencil = new Pencil(4,pencilColor);
		
		
		Container principal = this.getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(createCentralPanel(), BorderLayout.CENTER);
		this.pack();		
	}

	/*
	 * this part contains the tool box and the console area
	 */
	public JPanel createCentralPanel() {
		
		/* ---------------- create console area ------------------- */
		JPanel consoleArea = new JPanel();
		consoleArea.setLayout(new BoxLayout(consoleArea,BoxLayout.Y_AXIS));
		JTextArea textArea = new JTextArea("");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane consolePane = new JScrollPane(textArea);
		consolePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		consolePane.setPreferredSize(new Dimension(200,380));
		consoleArea.add(consolePane);
		JButton runBtn = new JButton("Run preview");
		runBtn.setAlignmentX(LEFT_ALIGNMENT);
		consoleArea.add(runBtn);
		JButton saveImg  =new JButton("Save image as (name) : ");
		saveImg.setAlignmentX(LEFT_ALIGNMENT);
		consoleArea.add(saveImg);
		JTextField imgNameInput = new JTextField(10);
		imgNameInput.setSize(10, 10);
		consoleArea.add(imgNameInput);
		JScrollPane consoleScrollPane = new JScrollPane(consoleArea);
		consoleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		/* ------------------------ create toolbox -------------------- */
		JPanel toolbox = new JPanel();
		JScrollPane toolboxScrollPane = new JScrollPane(toolbox);
		toolboxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		toolboxScrollPane.setPreferredSize(new Dimension(350,400));
		
		toolbox.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 4;
		gc.weighty = 13;

		/* ---------------- Creation of the components -----------------*/

		//Pencil and its style
		JLabel pencilStyle = new JLabel("Pencil style");
		pencilStyle.setFont(new Font("Label.font",Font.BOLD,15));
		JLabel pencilThickness = new JLabel("Pencil thickness");
		JTextField thicknessValue = new JTextField(10);
		JLabel pencilRed = new JLabel("Red : ");
		JTextField pencilRedValue = new JTextField(10);
		JLabel pencilGreen = new JLabel("Green : ");
		JTextField pencilGreenValue = new JTextField(10);
		JLabel pencilBlue = new JLabel("Blue : ");
		JTextField pencilBlueValue = new JTextField(10);

		/* Shapes section */

		//Button group
		ButtonGroup shapeBtns = new ButtonGroup();
		JLabel shapes = new JLabel("Shapes");
		shapes.setFont(new Font("Label.font",Font.BOLD,15));

		//Circle and its values
		JRadioButton circle = new JRadioButton("Circle");
		shapeBtns.add(circle);
		circle.setPreferredSize(new Dimension(10,10));
		JLabel circleX = new JLabel("Center X : ");
		toHide.add(circleX);
		JTextField centerX = new JTextField(3);
		toHide.add(centerX);
		JLabel circleY = new JLabel("Center Y : ");
		toHide.add(circleY);
		JTextField centerY = new JTextField(3);
		toHide.add(centerY);
		JLabel circleRadius = new JLabel("Circle radius : ");
		toHide.add(circleRadius);
		JTextField radiusValue = new JTextField(3);
		toHide.add(radiusValue);

		//Ellipse : center and radius values
		JRadioButton ellipse = new JRadioButton("Ellipse");
		shapeBtns.add(ellipse);
		ellipse.setPreferredSize(new Dimension(10,10));
		JLabel ellipseCenterX = new JLabel("Ellipse center X : ");
		toHide.add(ellipseCenterX);
		JTextField ellipseCenterValueX =  new JTextField(5);
		toHide.add(ellipseCenterValueX);
		JLabel ellipseCenterY = new JLabel("Ellipse center Y : ");
		toHide.add(ellipseCenterY);
		JTextField ellipseCenterValueY =  new JTextField(5);
		toHide.add(ellipseCenterValueY);
		JLabel ellipseRadiusX = new JLabel("Ellipse radius X : ");
		toHide.add(ellipseRadiusX);
		JTextField ellipseRadiusValueX =  new JTextField(5);
		toHide.add(ellipseRadiusValueX);
		JLabel ellipseRadiusY = new JLabel("Ellipse radius Y : ");
		toHide.add(ellipseRadiusY);
		JTextField ellipseRadiusValueY =  new JTextField(5);
		toHide.add(ellipseRadiusValueY);

		//Line and its points
		JRadioButton line = new JRadioButton("Line");
		shapeBtns.add(line);
		line.setPreferredSize(new Dimension(10,10));
		JLabel x1 = new JLabel("x1 : ");
		toHide.add(x1);
		JTextField x1Value = new JTextField(5);
		toHide.add(x1Value);
		JLabel y1 = new JLabel("y1 : ");
		toHide.add(y1);
		JTextField y1Value = new JTextField(5);
		toHide.add(y1Value);
		JLabel x2 = new JLabel("x2 : ");
		toHide.add(x2);
		JTextField x2Value = new JTextField(5);
		toHide.add(x2Value);
		JLabel y2 = new JLabel("y2 : ");
		toHide.add(y2);
		JTextField y2Value = new JTextField(5);
		toHide.add(y2Value);

		//Polygone
		JRadioButton polygone = new JRadioButton("Polygone");
		shapeBtns.add(polygone);
		polygone.setPreferredSize(new Dimension(10,10));
		JLabel xListPolygone = new JLabel("List of x : ");
		toHide.add(xListPolygone);
		JLabel xListPolygoneValues = new JLabel("");
		toHide.add(xListPolygoneValues);
		JLabel yListPolygone = new JLabel("List of y : ");
		toHide.add(yListPolygone);
		JLabel yListPolygoneValues = new JLabel("");
		toHide.add(yListPolygoneValues);
		JLabel xInputPolygone = new JLabel("Value of x : ");
		toHide.add(xInputPolygone);
		JTextField xInputPolygoneValue  =new JTextField("");
		toHide.add(xInputPolygoneValue);
		JLabel yInputPolygone = new JLabel("Value of y : ");
		toHide.add(yInputPolygone);
		JTextField yInputPolygoneValue  =new JTextField("");
		toHide.add(yInputPolygoneValue);
		JButton addPointPolygone = new JButton("Add point");
		addPointPolygone.setPreferredSize(new Dimension(10,10));
		toHide.add(addPointPolygone);

		//Polyline
		JRadioButton polyline = new JRadioButton("Polyline");
		shapeBtns.add(polyline);
		polyline.setPreferredSize(new Dimension(10,10));
		JLabel xListPolyline = new JLabel("List of x : ");
		toHide.add(xListPolyline);
		JLabel xListPolylineValues = new JLabel("");
		toHide.add(xListPolylineValues);
		JLabel yListPolyline = new JLabel("List of y : ");
		toHide.add(yListPolyline);
		JLabel yListPolylineValues = new JLabel("");
		toHide.add(yListPolylineValues);
		JLabel xInputPolyline = new JLabel("Value of x : ");
		toHide.add(xInputPolyline);
		JTextField xInputPolylineValue  =new JTextField("");
		toHide.add(xInputPolylineValue);
		JLabel yInputPolyline = new JLabel("Value of y : ");
		toHide.add(yInputPolyline);
		JTextField yInputPolylineValue  =new JTextField("");
		toHide.add(yInputPolylineValue);
		JButton addPointPolyline = new JButton("Add point");
		addPointPolyline.setPreferredSize(new Dimension(10,10));
		toHide.add(addPointPolyline);
		
		//Rectangle and its values
		JRadioButton rectangle = new JRadioButton("Rectangle");
		shapeBtns.add(rectangle);
		rectangle.setPreferredSize(new Dimension(10,10));
		JLabel rectX = new JLabel("Rectangle X : ");
		toHide.add(rectX);
		JTextField rectValueX = new JTextField(10);
		toHide.add(rectValueX);
		JLabel rectY = new JLabel("Rectangle Y : ");
		toHide.add(rectY);
		JTextField rectValueY = new JTextField(10);
		toHide.add(rectValueY);
		JLabel rectWidth = new JLabel("Rectangle width : ");
		toHide.add(rectWidth);
		JTextField rectWidthValue = new JTextField(10);
		toHide.add(rectWidthValue);
		JLabel rectHeight = new JLabel("Rectangle height : ");
		toHide.add(rectHeight);
		JTextField rectHeightValue = new JTextField(10);
		toHide.add(rectHeightValue);

		//Text and its values
		JRadioButton text = new JRadioButton("Text");
		shapeBtns.add(text);
		text.setPreferredSize(new Dimension(10,10));
		JLabel textX = new JLabel("Text X : ");
		toHide.add(textX);
		JTextField textValueX = new JTextField(10);
		toHide.add(textValueX);
		JLabel textY = new JLabel("Text Y : ");
		toHide.add(textY);
		JTextField textValueY = new JTextField(10);
		toHide.add(textValueY);
		JLabel textValueLabel = new JLabel("Text value : ");
		toHide.add(textValueLabel);
		JTextField textValue = new JTextField(10);
		toHide.add(textValue);

		//Fill when possible
		JLabel fill = new JLabel("Fill");
		fill.setFont(new Font("Label.font",Font.BOLD,15));
		//yes and no : the default is no
		ButtonGroup fillChoices = new ButtonGroup();
		JRadioButton yesToFill = new JRadioButton("Yes");
		fillChoices.add(yesToFill);
		JRadioButton noToFill = new JRadioButton("No");
		fillChoices.add(noToFill);
		//the color for the fill function in case of yes
		JLabel fillRed = new JLabel("Red : ");
//		toHide.add(fillRed);
		JTextField fillRedValue = new JTextField(10);
//		toHide.add(fillRedValue);
		JLabel fillGreen = new JLabel("Green : ");
//		toHide.add(fillGreen);
		JTextField fillGreenValue = new JTextField(10);
//		toHide.add(fillGreenValue);
		JLabel fillBlue = new JLabel("Blue : ");
//		toHide.add(fillBlue);
		JTextField fillBlueValue = new JTextField(10);
//		toHide.add(fillBlueValue);
		JButton addShape = new JButton("Add");
		addShape.setPreferredSize(new Dimension(10,10));


		/* ----------------- Putting the components in the Gridlayout --------- */

		//putting circle elements in the gridlayout
		gc.gridx = 0;
		gc.gridy = 0;
		toolbox.add(pencilStyle, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(pencilThickness, gc);
		gc.gridx++;
		toolbox.add(thicknessValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(pencilRed, gc);
		gc.gridx++;
		toolbox.add(pencilRedValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(pencilGreen, gc);
		gc.gridx++;
		toolbox.add(pencilGreenValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(pencilBlue, gc);
		gc.gridx++;
		toolbox.add(pencilBlueValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(shapes, gc);
		gc.gridy++;
		toolbox.add(circle, gc);
		gc.gridy++;
		toolbox.add(circleX, gc);
		gc.gridx++;
		toolbox.add(centerX, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(circleY, gc);
		gc.gridx++;
		toolbox.add(centerY, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(circleRadius, gc);
		gc.gridx++;
		toolbox.add(radiusValue, gc);

		//puttong ellipse elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(ellipse, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(ellipseCenterX, gc);
		gc.gridx++;
		toolbox.add(ellipseCenterValueX, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(ellipseCenterY, gc);
		gc.gridx++;
		toolbox.add(ellipseCenterValueY, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(ellipseRadiusX, gc);
		gc.gridx++;
		toolbox.add(ellipseRadiusValueX, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(ellipseRadiusY, gc);
		gc.gridx++;
		toolbox.add(ellipseRadiusValueY, gc);

		//putting line elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(line, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(x1, gc);
		gc.gridx++;
		toolbox.add(x1Value, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(y1, gc);
		gc.gridx++;
		toolbox.add(y1Value, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(x2, gc);
		gc.gridx++;
		toolbox.add(x2Value, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(y2, gc);
		gc.gridx++;
		toolbox.add(y2Value, gc);

		//putting polygone elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(polygone, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xListPolygone, gc);
		gc.gridx++;
		toolbox.add(xListPolygoneValues, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yListPolygone, gc);
		gc.gridx++;
		toolbox.add(yListPolygoneValues, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xInputPolygone, gc);
		gc.gridx++;
		toolbox.add(xInputPolygoneValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yInputPolygone, gc);
		gc.gridx++;
		toolbox.add(yInputPolygoneValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addPointPolygone, gc);

		//putting polyline elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(polyline, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xListPolyline, gc);
		gc.gridx++;
		toolbox.add(xListPolylineValues, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yListPolyline, gc);
		gc.gridx++;
		toolbox.add(yListPolylineValues, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xInputPolyline, gc);
		gc.gridx++;
		toolbox.add(xInputPolylineValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yInputPolyline, gc);
		gc.gridx++;
		toolbox.add(yInputPolylineValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addPointPolyline, gc);

		//putting rectangle elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectangle, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectX, gc);
		gc.gridx = 1;
		toolbox.add(rectValueX, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectY, gc);
		gc.gridx++;
		toolbox.add(rectValueY, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectWidth, gc);
		gc.gridx++;
		toolbox.add(rectWidthValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectHeight, gc);
		gc.gridx++;
		toolbox.add(rectHeightValue, gc);

		//putting text elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(text, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textX, gc);
		gc.gridx++;
		toolbox.add(textValueX, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textY, gc);
		gc.gridx++;
		toolbox.add(textValueY, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textValueLabel, gc);
		gc.gridx++;
		toolbox.add(textValue, gc);

		/* Fill when possible */
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(fill, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yesToFill, gc);
		gc.gridx++;
		toolbox.add(noToFill, gc);
		noToFill.setSelected(true);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(fillRed, gc);
		gc.gridx++;
		toolbox.add(fillRedValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(fillGreen, gc);
		gc.gridx++;
		toolbox.add(fillGreenValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(fillBlue, gc);
		gc.gridx++;
		toolbox.add(fillBlueValue, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addShape, gc);

		/* --------------- Hide components at initialization ------------------- */

		//hide circle fields
		circleX.setVisible(false);
		centerX.setVisible(false);
		circleY.setVisible(false);
		centerY.setVisible(false);
		circleRadius.setVisible(false);
		radiusValue.setVisible(false);
		
		//hide ellipse fields
		ellipseCenterX.setVisible(false);
		ellipseCenterValueX.setVisible(false);
		ellipseCenterY.setVisible(false);
		ellipseCenterValueY.setVisible(false);
		ellipseRadiusX.setVisible(false);
		ellipseRadiusValueX.setVisible(false);
		ellipseRadiusY.setVisible(false);
		ellipseRadiusValueY.setVisible(false);
		
		//hide line fields
		x1.setVisible(false);
		x1Value.setVisible(false);
		y1.setVisible(false);
		y1Value.setVisible(false);
		x2.setVisible(false);
		x2Value.setVisible(false);
		y2.setVisible(false);
		y2Value.setVisible(false);
		
		//hide polygone fields
		xListPolygone.setVisible(false);
		xListPolygoneValues.setVisible(false);
		yListPolygone.setVisible(false);
		yListPolygoneValues.setVisible(false);
		xInputPolygone.setVisible(false);
		xInputPolygoneValue.setVisible(false);
		yInputPolygone.setVisible(false);
		yInputPolygoneValue.setVisible(false);
		addPointPolygone.setVisible(false);
		
		//hide polyline fields
		xListPolyline.setVisible(false);
		xListPolylineValues.setVisible(false);
		yListPolyline.setVisible(false);
		yListPolylineValues.setVisible(false);
		xInputPolyline.setVisible(false);
		xInputPolylineValue.setVisible(false);
		yInputPolyline.setVisible(false);
		yInputPolylineValue.setVisible(false);
		addPointPolyline.setVisible(false);
		
		//hide rectangle fields
		rectX.setVisible(false);
		rectValueX.setVisible(false);
		rectY.setVisible(false);
		rectValueY.setVisible(false);
		rectWidth.setVisible(false);
		rectWidthValue.setVisible(false);
		rectHeight.setVisible(false);
		rectHeightValue.setVisible(false);
		
		//hide text fields
		textX.setVisible(false);
		textValueX.setVisible(false);
		textY.setVisible(false);
		textValueY.setVisible(false);
		textValueLabel.setVisible(false);
		textValue.setVisible(false);
		
		//hide fill color fields
		fillRed.setVisible(false);
		fillRedValue.setVisible(false);
		fillGreen.setVisible(false);
		fillGreenValue.setVisible(false);
		fillBlue.setVisible(false);
		fillBlueValue.setVisible(false);

		/* -------------------- Listeners ------------------------------------- */

		//circle's listener
		ControlCircleRadioBtn circleController = new ControlCircleRadioBtn(
				circleX, centerX, 
				circleY, centerY, 
				circleRadius, radiusValue,this, yesToFill, noToFill);
		circle.addActionListener(circleController);

		//ellipse's listener
		ControlEllipseRadioBtn ellipseController = new ControlEllipseRadioBtn(ellipseCenterX, 
				ellipseCenterValueX,ellipseCenterY, ellipseCenterValueY, ellipseRadiusX,
				ellipseRadiusValueX, ellipseRadiusY, ellipseRadiusValueY,this, yesToFill,
				noToFill);
		ellipse.addActionListener(ellipseController);

		//line's listener
		ControlLineRadioBtn lineController = new ControlLineRadioBtn(x1,x1Value, 
				y1,y1Value,x2, x2Value, y2,  y2Value, this, yesToFill, noToFill);
		line.addActionListener(lineController);

		//polygone's listener
		ControlPolygoneRadioBtn polygoneController = new ControlPolygoneRadioBtn(polygoneModele, 
				xListPolygone, xListPolygoneValues,yListPolygone, yListPolygoneValues, 
				xInputPolygone, xInputPolygoneValue, yInputPolygone, yInputPolygoneValue,
				addPointPolygone, this, yesToFill, noToFill);
		polygone.addActionListener(polygoneController);
//		polygoneModele.addObserver(polygoneController);

		//Polygone's addPoint button listener
		ControlAddPointPolygone addPointPolygoneController = new ControlAddPointPolygone(polygoneModele, 
				xListPolygoneValues, yListPolygoneValues, xInputPolygoneValue, 
				 yInputPolygoneValue); 
		addPointPolygone.addActionListener(addPointPolygoneController);
		polygoneModele.addObserver(addPointPolygoneController);

		//polyline's listener
		ControlPolylineRadioBtn polylineController = new ControlPolylineRadioBtn(
				xListPolyline, xListPolylineValues, yListPolyline, yListPolylineValues, xInputPolyline, xInputPolylineValue, yInputPolyline, yInputPolylineValue,
				addPointPolyline, this , yesToFill, noToFill);
		polyline.addActionListener(polylineController);

		//Polyline's addPoint button listener
		ControlAddPointPolyline addPointPolylineController = new ControlAddPointPolyline(polylineModele, 
				xListPolylineValues, yListPolylineValues, xInputPolylineValue, 
				yInputPolylineValue); 
		addPointPolyline.addActionListener(addPointPolylineController);
		polylineModele.addObserver(addPointPolylineController);
		
		
		//rectangle's listener
		ControlRectangleRadioBtn rectangleController =  new ControlRectangleRadioBtn(rectX, rectValueX, 
				rectY, rectValueY,rectWidth, rectWidthValue,rectHeight,
				rectHeightValue, this, yesToFill, noToFill);
		rectangle.addActionListener(rectangleController);

		//text's listener
		ControlTextRadioBtn textController = new ControlTextRadioBtn(textX, textValueX, 
				textY, textValueY, textValueLabel, textValue, this, yesToFill, noToFill);
		text.addActionListener(textController);

		// fill radio buttons' controllers
		ControlFillYesRadioBtn fillYesController = new ControlFillYesRadioBtn(fillRed, 
				fillRedValue,fillGreen, fillGreenValue, fillBlue, fillBlueValue); 
		yesToFill.addActionListener(fillYesController);

		ControlFillNoRadioBtn fillNoController = new ControlFillNoRadioBtn(fillRed, 
				fillRedValue,fillGreen, fillGreenValue, fillBlue, fillBlueValue); 
		noToFill.addActionListener(fillNoController);
		
		//add button's listener
		AddToConsoleController addController = new AddToConsoleController(fillColor, fillRedValue, fillGreenValue,
				fillBlueValue, pencil, pencilColor, thicknessValue,
				pencilRedValue, pencilGreenValue, pencilBlueValue, circleModele,
				centerX, centerY, radiusValue, ellipseModele,
				ellipseCenterValueX, ellipseCenterValueY,ellipseRadiusValueX,
				ellipseRadiusValueY, lineModele, x1Value, y1Value, x2Value, y2Value,
				polygoneModele, xListPolygoneValues, yListPolygoneValues, 
				xInputPolygoneValue, yInputPolygoneValue, 
				polylineModele, xListPolylineValues, yListPolylineValues, 
				xInputPolylineValue, yInputPolylineValue, 
				rectangleModele, rectValueX, rectValueY,
				rectWidthValue, rectHeightValue, textModele, textValueX, textValueY, 
				textValue, textArea, shapeList);
		addShape.addActionListener(addController);
		pencil.addObserver(addController);
		
		//run button's listener : display the AWT
		ControlRunGUI runController = new ControlRunGUI(shapeList);
		runBtn.addActionListener(runController);
		
		//save image's listener
		ControlSaveSVGImg saveImgController = new ControlSaveSVGImg(shapeList, imgNameInput);
		saveImg.addActionListener(saveImgController);
		
		
		/* Create JSplitPane for the layout */
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.setBorder(new EmptyBorder(5,5,5,5));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolboxScrollPane, consoleScrollPane);
		left.add(splitPane);
		return left;
	}


	
	public void hideComponents(){
		for(int i=0;i<toHide.size();i++){
			toHide.get(i).setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
