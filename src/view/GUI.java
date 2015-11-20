package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;

import controller.guiController.ControlCircleRadioBtn;
import controller.guiController.ControlEllipseRadioBtn;
import controller.guiController.ControlLineRadioBtn;
import controller.guiController.ControlPolygoneRadioBtn;
import controller.guiController.ControlPolylineRadioBtn;
import controller.guiController.ControlRectangleRadioBtn;
import controller.guiController.ControlTextRadioBtn;
import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import model.specific_path.Polygone;
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
	private Polygone polygoneModele;
	private Polyline polylineModele;
	private Rectangle rectangleModele;
	private Text textModele;
	
	private ArrayList<JComponent> toHide = new ArrayList<JComponent>();

	private static final long serialVersionUID = 7101648530122179966L;

	public GUI(){
		super("Drawing interface");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//create the models
		this.circleModele = new Circle();
		this.ellipseModele = new Ellipse();
		this.lineModele = new Line();
		this.polygoneModele = new Polygone();
		this.polylineModele = new Polyline();
		this.rectangleModele = new Rectangle();
		this.textModele = new Text();


		Container principal = this.getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(createCentralPanel(), BorderLayout.SOUTH);
		this.pack();		
	}

	/*
	 * this part contains the tool box and the console area
	 */
	public JPanel createCentralPanel() {
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		//JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, createToolBox(), createConsole());		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createToolBox(), createConsole());
		left.add(splitPane);
		return left;
	}

	/**
	 * the tool box contains style and shape elements such as pencil,
	 * color, thickness, fill, circle, rectangle, ...
	 */
	public JScrollPane createToolBox() {
		JPanel toolbox = new JPanel();
		JScrollPane scrollPane = new JScrollPane(toolbox);
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350,400));

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
		JLabel pencilColor = new JLabel("Pencil color");
		JTextField pencilColorValue = new JTextField(10);
		JLabel pencilThickness = new JLabel("Pencil thickness");
		JTextField thicknessValue = new JTextField(10);
		//TODO

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
		JLabel xListPolygoneValues = new JLabel("");
		JLabel yListPolygone = new JLabel("List of y : ");
		JLabel yListPolygoneValues = new JLabel("");
		JLabel xInputPolygone = new JLabel("Value of x : ");
		JTextField xInputPolygoneValue  =new JTextField("");
		JLabel yInputPolygone = new JLabel("Value of y : ");
		JTextField yInputPolygoneValue  =new JTextField("");
		JButton addPointPolygone = new JButton("Add point");
		addPointPolygone.setPreferredSize(new Dimension(10,10));

		//Polyline
		JRadioButton polyline = new JRadioButton("Polyline");
		shapeBtns.add(polyline);
		polyline.setPreferredSize(new Dimension(10,10));
		JLabel xListPolyline = new JLabel("List of x : ");
		JLabel xListPolylineValues = new JLabel("");
		JLabel yListPolyline = new JLabel("List of y : ");
		JLabel yListPolylineValues = new JLabel("");
		JLabel xInputPolyline = new JLabel("Value of x : ");
		JTextField xInputPolylineValue  =new JTextField("");
		JLabel yInputPolyline = new JLabel("Value of y : ");
		JTextField yInputPolylineValue  =new JTextField("");
		JButton addPointPolyline = new JButton("Add point");
		addPointPolyline.setPreferredSize(new Dimension(10,10));
		
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
		JLabel fillColor = new JLabel("Fill color : ");
		JTextField fillColorValue = new JTextField(10);
		JButton addShape = new JButton("Add");
		addShape.setPreferredSize(new Dimension(10,10));


		/* ----------------- Putting the components in the Gridlayout --------- */

		//putting circle elements in the gridlayout
		gc.gridx = 0;
		gc.gridy = 0;
		toolbox.add(pencilStyle, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		toolbox.add(pencilColor, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		toolbox.add(pencilColorValue, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		toolbox.add(pencilThickness, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		toolbox.add(thicknessValue, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		toolbox.add(shapes, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		toolbox.add(circle, gc);
		gc.gridy = 5;
		toolbox.add(circleX, gc);
		//hide before click
		circleX.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 5;
		toolbox.add(centerX, gc);
		//hide before click
		centerX.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 6;
		toolbox.add(circleY, gc);
		//hide before click
		circleY.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 6;
		toolbox.add(centerY, gc);
		//hide before click
		centerY.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 7;
		toolbox.add(circleRadius, gc);
		//hide before click
		circleRadius.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 7;
		toolbox.add(radiusValue, gc);
		//hide before click
		radiusValue.setVisible(false);

		//puttong ellipse elements in the gridlayout
		gc.gridx = 0;
		gc.gridy = 8;
		toolbox.add(ellipse, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		toolbox.add(ellipseCenterX, gc);
		//hide before click
		ellipseCenterX.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 9;
		toolbox.add(ellipseCenterValueX, gc);
		//hide before click
		ellipseCenterValueX.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 10;
		toolbox.add(ellipseCenterY, gc);
		//hide before click
		ellipseCenterY.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 10;
		toolbox.add(ellipseCenterValueY, gc);
		//hide before click
		ellipseCenterValueY.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 11;
		toolbox.add(ellipseRadiusX, gc);
		//hide before click
		ellipseRadiusX.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 11;
		toolbox.add(ellipseRadiusValueX, gc);
		//hide before click
		ellipseRadiusValueX.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 12;
		toolbox.add(ellipseRadiusY, gc);
		//hide before click
		ellipseRadiusY.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 12;
		toolbox.add(ellipseRadiusValueY, gc);
		//hide before click
		ellipseRadiusValueY.setVisible(false);

		//putting line elements in the gridlayout
		gc.gridx = 0;
		gc.gridy = 13;
		toolbox.add(line, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		toolbox.add(x1, gc);
		//hide before click
		x1.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 14;
		toolbox.add(x1Value, gc);
		//hide before click
		x1Value.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 15;
		toolbox.add(y1, gc);
		//hide before click
		y1.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 15;
		toolbox.add(y1Value, gc);
		//hide before click
		y1Value.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 16;
		toolbox.add(x2, gc);
		//hide before click
		x2.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 16;
		toolbox.add(x2Value, gc);
		//hide before click
		x2Value.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 17;
		toolbox.add(y2, gc);
		//hide before click
		y2.setVisible(false);
		gc.gridx = 1;
		gc.gridy = 17;
		toolbox.add(y2Value, gc);
		y2Value.setVisible(false);


		//putting polygone elements in the gridlayout
		gc.gridx = 0;
		gc.gridy = 18;
		toolbox.add(polygone, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xListPolygone, gc);
		xListPolygone.setVisible(false);
		gc.gridx++;
		toolbox.add(xListPolygoneValues, gc);
		xListPolygoneValues.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yListPolygone, gc);
		yListPolygone.setVisible(false);
		gc.gridx++;
		toolbox.add(yListPolygoneValues, gc);
		yListPolygoneValues.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xInputPolygone, gc);
		xInputPolygone.setVisible(false);
		gc.gridx++;
		toolbox.add(xInputPolygoneValue, gc);
		xInputPolygoneValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yInputPolygone, gc);
		yInputPolygone.setVisible(false);
		gc.gridx++;
		toolbox.add(yInputPolygoneValue, gc);
		yInputPolygoneValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addPointPolygone, gc);
		addPointPolygone.setVisible(false);

		//putting polyline elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(polyline, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xListPolyline, gc);
		xListPolyline.setVisible(false);
		gc.gridx++;
		toolbox.add(xListPolylineValues, gc);
		xListPolylineValues.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yListPolyline, gc);
		yListPolyline.setVisible(false);
		gc.gridx++;
		toolbox.add(yListPolylineValues, gc);
		yListPolylineValues.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(xInputPolyline, gc);
		xInputPolyline.setVisible(false);
		gc.gridx++;
		toolbox.add(xInputPolylineValue, gc);
		xInputPolylineValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(yInputPolyline, gc);
		yInputPolyline.setVisible(false);
		gc.gridx++;
		toolbox.add(yInputPolylineValue, gc);
		yInputPolylineValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addPointPolyline, gc);
		addPointPolyline.setVisible(false);

		//putting rectangle elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectangle, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectX, gc);
		//hide before click
		rectX.setVisible(false);
		gc.gridx = 1;
		toolbox.add(rectValueX, gc);
		//hide before click
		rectValueX.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectY, gc);
		//hide before click
		rectY.setVisible(false);
		gc.gridx++;
		toolbox.add(rectValueY, gc);
		//hide before click
		rectValueY.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectWidth, gc);
		//hide before click
		rectWidth.setVisible(false);
		gc.gridx++;
		toolbox.add(rectWidthValue, gc);
		//hide before click
		rectWidthValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(rectHeight, gc);
		//hide before click
		rectHeight.setVisible(false);
		gc.gridx++;
		toolbox.add(rectHeightValue, gc);
		//hide before click
		rectHeightValue.setVisible(false);


		//putting text elements in the gridlayout
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(text, gc);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textX, gc);
		//hide before click
		textX.setVisible(false);
		gc.gridx++;
		toolbox.add(textValueX, gc);
		//hide before click
		textValueX.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textY, gc);
		//hide before click
		textY.setVisible(false);
		gc.gridx++;
		toolbox.add(textValueY, gc);
		//hide before click
		textValueY.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(textValueLabel, gc);
		//hide before click
		textValueLabel.setVisible(false);
		gc.gridx++;
		toolbox.add(textValue, gc);
		//hide before click
		textValue.setVisible(false);

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
		toolbox.add(fillColor, gc);
		//hide before click
		fillColor.setVisible(false);
		gc.gridx++;
		toolbox.add(fillColorValue, gc);
		//hide before click
		fillColorValue.setVisible(false);
		gc.gridx = 0;
		gc.gridy++;
		toolbox.add(addShape, gc);



		/* -------------------- Listeners ------------------------------	 */

		//circle's listener
		ControlCircleRadioBtn circleController = new ControlCircleRadioBtn(new Circle(),
				circleX, centerX, 
				circleY, centerY, 
				circleRadius, radiusValue,this);
		circle.addActionListener(circleController);
		circleModele.addObserver(circleController);

		//ellipse's listener
		ControlEllipseRadioBtn ellipseController = new ControlEllipseRadioBtn(ellipseModele,ellipseCenterX, 
				ellipseCenterValueX,ellipseCenterY, ellipseCenterValueY, ellipseRadiusX,
				ellipseRadiusValueX, ellipseRadiusY, ellipseRadiusValueY,this);
		ellipse.addActionListener(ellipseController);
		ellipseModele.addObserver(ellipseController);

		//line's listener
		ControlLineRadioBtn lineController = new ControlLineRadioBtn(lineModele,x1,x1Value, 
				y1,y1Value,x2, x2Value, y2,  y2Value, this);
		line.addActionListener(lineController);
		lineModele.addObserver(lineController);
		
		//polygone's listener
		ControlPolygoneRadioBtn polygoneController = new ControlPolygoneRadioBtn(polygoneModele, 
				xListPolygone, xListPolygoneValues,yListPolygone, yListPolygoneValues, 
				xInputPolygone, xInputPolygoneValue, yInputPolygone, yInputPolygoneValue,
				addPointPolygone, this);
		polygone.addActionListener(polygoneController);
		polygoneModele.addObserver(polygoneController);
		
		//polyline's listener
		ControlPolylineRadioBtn polylineController = new ControlPolylineRadioBtn(polylineModele, 
				xListPolyline, xListPolylineValues, yListPolyline, yListPolylineValues, 
				xInputPolyline, xInputPolylineValue, yInputPolyline, yInputPolylineValue,
				addPointPolyline, this);
		polyline.addActionListener(polylineController);
		polylineModele.addObserver(polylineController);
		
		//rectangle's listener
		ControlRectangleRadioBtn rectangleController =  new ControlRectangleRadioBtn(rectangleModele,rectX, rectValueX, 
				rectY, rectValueY,rectWidth, rectWidthValue,rectHeight,
				rectHeightValue, this);
		rectangle.addActionListener(rectangleController);
		rectangleModele.addObserver(rectangleController);
		
		//text's listener
		ControlTextRadioBtn textController = new ControlTextRadioBtn(textModele, textX, textValueX, 
				textY, textValueY, textValueLabel, textValue, this);
		text.addActionListener(textController);
		textModele.addObserver(textController);



		return scrollPane;
	}

	/*
	 * the console for the Java commands
	 */
	public JPanel createConsole() {

		JPanel consoleArea = new JPanel();
		consoleArea.setLayout(new BoxLayout(consoleArea,BoxLayout.Y_AXIS));

		JTextArea textArea = new JTextArea("Some commands ....");
		//textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//textArea.setSize(100, 1);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(200,200));

		consoleArea.add(scrollPane);
		JButton pencil = new JButton("Run");

		//pencil.setBackground(Color.RED);
		//		pencil.setFont(new Font("Arial",Font.BOLD,16));
		//		pencil.setForeground(Color.WHITE);
		pencil.setAlignmentX(LEFT_ALIGNMENT);

		consoleArea.add(pencil);

		return consoleArea;		
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
