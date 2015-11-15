package view;

import java.awt.*;
import javax.swing.*;

/*
 * this class creates the graphical user interface for the svg drawing
 */
public class GUI extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7101648530122179966L;

	public GUI(){
		super("Drawing interface");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		//Pencil and its style
		gc.gridx = 0;
		gc.gridy = 0;
		JLabel pencilStyle = new JLabel("Pencil style");
		pencilStyle.setFont(new Font("Label.font",Font.BOLD,15));
		toolbox.add(pencilStyle, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		JLabel pencilColor = new JLabel("Pencil color");
		toolbox.add(pencilColor, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		JTextField pencilColorValue = new JTextField(10);
		toolbox.add(pencilColorValue, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		JLabel pencilThickness = new JLabel("Pencil thickness");
		toolbox.add(pencilThickness, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		JTextField thicknessValue = new JTextField(10);
		toolbox.add(thicknessValue, gc);

		/* Shapes section */
		
		//Button group
		ButtonGroup shapeBtns = new ButtonGroup();
		
		gc.gridx = 0;
		gc.gridy = 3;
		JLabel shapes = new JLabel("Shapes");
		shapes.setFont(new Font("Label.font",Font.BOLD,15));
		toolbox.add(shapes, gc);
		
		//Circle  : center and radius values
		gc.gridx = 0;
		gc.gridy = 4;
//		JButton circle = new JButton("Circle");
		JRadioButton circle = new JRadioButton("Circle");
		shapeBtns.add(circle);
		circle.setPreferredSize(new Dimension(10,10));
		toolbox.add(circle, gc);

		gc.gridx = 0;
		gc.gridy = 5;
		JLabel circleX = new JLabel("Center X : ");
		toolbox.add(circleX, gc);

		//hide before click
		circleX.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 5;
		JTextField centerX = new JTextField(3);
		toolbox.add(centerX, gc);
		
		//hide before click
		centerX.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 6;
		JLabel circleY = new JLabel("Center Y : ");
		toolbox.add(circleY, gc);
		
		//hide before click
		circleY.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 6;
		JTextField centerY = new JTextField(3);
		toolbox.add(centerY, gc);
		
		//hide before click
		centerY.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 7;
		JLabel circleRadius = new JLabel("Circle radius : ");
		toolbox.add(circleRadius, gc);
		
		//hide before click
		circleRadius.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 7;
		JTextField radiusValue = new JTextField(3);
		toolbox.add(radiusValue, gc);
		
		//hide before click
		radiusValue.setVisible(false);


		//Ellipse : center and radius values
		gc.gridx = 0;
		gc.gridy = 8;
		JRadioButton ellipse = new JRadioButton("Ellipse");
		shapeBtns.add(ellipse);
		ellipse.setPreferredSize(new Dimension(10,10));
		toolbox.add(ellipse, gc);

		gc.gridx = 0;
		gc.gridy = 9;
		JLabel ellipseCenterX = new JLabel("Ellipse center X : ");
		toolbox.add(ellipseCenterX, gc);
		
		//hide before click
		ellipseCenterX.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 9;
		JTextField ellipseCenterValueX =  new JTextField(5);
		toolbox.add(ellipseCenterValueX, gc);
		
		//hide before click
		ellipseCenterValueX.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 10;
		JLabel ellipseCenterY = new JLabel("Ellipse center Y : ");
		toolbox.add(ellipseCenterY, gc);
		
		//hide before click
		ellipseCenterY.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 10;
		JTextField ellipseCenterValueY =  new JTextField(5);
		toolbox.add(ellipseCenterValueY, gc);
		
		//hide before click
		ellipseCenterValueY.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 11;
		JLabel ellipseRadiusX = new JLabel("Ellipse radius X : ");
		toolbox.add(ellipseRadiusX, gc);
		
		//hide before click
		ellipseRadiusX.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 11;
		JTextField ellipseRadiusValueX =  new JTextField(5);
		toolbox.add(ellipseRadiusValueX, gc);
		
		//hide before click
		ellipseRadiusValueX.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 12;
		JLabel ellipseRadiusY = new JLabel("Ellipse radius Y : ");
		toolbox.add(ellipseRadiusY, gc);
		
		//hide before click
		ellipseRadiusY.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 12;
		JTextField ellipseRadiusValueY =  new JTextField(5);
		toolbox.add(ellipseRadiusValueY, gc);
		
		//hide before click
		ellipseRadiusValueY.setVisible(false);

		//Line and its points
		gc.gridx = 0;
		gc.gridy = 13;
//		JButton line = new JButton("Line");
		JRadioButton line = new JRadioButton("Line");
		shapeBtns.add(line);
		line.setPreferredSize(new Dimension(10,10));
		toolbox.add(line, gc);

		gc.gridx = 0;
		gc.gridy = 14;
		JLabel x1 = new JLabel("x1 : ");
		toolbox.add(x1, gc);
		
		//hide before click
		x1.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 14;
		JTextField x1Value = new JTextField(5);
		toolbox.add(x1Value, gc);
		
		//hide before click
		x1Value.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 15;
		JLabel y1 = new JLabel("y1 : ");
		toolbox.add(y1, gc);
		
		//hide before click
		y1.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 15;
		JTextField y1Value = new JTextField(5);
		toolbox.add(y1Value, gc);
		
		//hide before click
		y1Value.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 16;
		JLabel x2 = new JLabel("x2 : ");
		toolbox.add(x2, gc);
		
		//hide before click
		x2.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 16;
		JTextField x2Value = new JTextField(5);
		toolbox.add(x2Value, gc);
		
		//hide before click
		x2Value.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 17;
		JLabel y2 = new JLabel("y2 : ");
		toolbox.add(y2, gc);
		
		//hide before click
		y2.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 17;
		JTextField y2Value = new JTextField(5);
		toolbox.add(y2Value, gc);
		
		y2Value.setVisible(false);


		//Polygone
		gc.gridx = 0;
		gc.gridy = 18;
//		JButton polygone = new JButton("Polygone");
		JRadioButton polygone = new JRadioButton("Polygone");
		shapeBtns.add(polygone);
		polygone.setPreferredSize(new Dimension(10,10));
		toolbox.add(polygone, gc);

		//Polyline
		gc.gridx = 0;
		gc.gridy = 19;
//		JButton polyline = new JButton("Polyline");
		JRadioButton polyline = new JRadioButton("Polylint");
		shapeBtns.add(polyline);
		polyline.setPreferredSize(new Dimension(10,10));
		toolbox.add(polyline, gc);

		//Rectangle and its values
		gc.gridx = 0;
		gc.gridy = 20;
//		JButton rectangle = new JButton("Rectangle");
		JRadioButton rectangle = new JRadioButton("Rectangle");
		shapeBtns.add(rectangle);
		rectangle.setPreferredSize(new Dimension(10,10));
		toolbox.add(rectangle, gc);

		gc.gridx = 0;
		gc.gridy = 21;
		JLabel rectX = new JLabel("Rectangle X : ");
		toolbox.add(rectX, gc);
		
		//hide before click
		rectX.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 21;
		JTextField rectValueX = new JTextField(10);
		toolbox.add(rectValueX, gc);
		
		//hide before click
		rectValueX.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 22;
		JLabel rectY = new JLabel("Rectangle Y : ");
		toolbox.add(rectY, gc);
		
		//hide before click
		rectY.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 22;
		JTextField rectValueY = new JTextField(10);
		toolbox.add(rectValueY, gc);
		
		//hide before click
		rectValueY.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 23;
		JLabel rectWidth = new JLabel("Rectangle width : ");
		toolbox.add(rectWidth, gc);
		
		//hide before click
		rectWidth.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 23;
		JTextField rectWidthValue = new JTextField(10);
		toolbox.add(rectWidthValue, gc);
		
		//hide before click
		rectWidthValue.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 24;
		JLabel rectHeight = new JLabel("Rectangle height : ");
		toolbox.add(rectHeight, gc);
		
		//hide before click
		rectHeight.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 24;
		JTextField rectHeightValue = new JTextField(10);
		toolbox.add(rectHeightValue, gc);
		
		//hide before click
		rectHeightValue.setVisible(false);

		//Text and its values
		gc.gridx = 0;
		gc.gridy = 25;
//		JButton text = new JButton("Text");
		JRadioButton text = new JRadioButton("Text");
		shapeBtns.add(text);
		text.setPreferredSize(new Dimension(10,10));
		toolbox.add(text, gc);

		gc.gridx = 0;
		gc.gridy = 26;
		JLabel textX = new JLabel("Text X : ");
		toolbox.add(textX, gc);
		
		//hide before click
		textX.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 26;
		JTextField textValueX = new JTextField(10);
		toolbox.add(textValueX, gc);
		
		//hide before click
		textValueX.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 27;
		JLabel textY = new JLabel("Text Y : ");
		toolbox.add(textY, gc);
		
		//hide before click
		textY.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 27;
		JTextField textValueY = new JTextField(10);
		toolbox.add(textValueY, gc);
		
		//hide before click
		textValueY.setVisible(false);

		gc.gridx = 0;
		gc.gridy = 28;
		JLabel textValueLabel = new JLabel("Text value : ");
		toolbox.add(textValueLabel, gc);

		//hide before click
		textValueLabel.setVisible(false);
		
		gc.gridx = 1;
		gc.gridy = 28;
		JTextField textValue = new JTextField(10);
		toolbox.add(textValue, gc);
		
		//hide before click
		textValue.setVisible(false);
		
		/* Fill when possible */
		gc.gridx = 0;
		gc.gridy = 29;
		JLabel fill = new JLabel("Fill");
		fill.setFont(new Font("Label.font",Font.BOLD,15));
		toolbox.add(fill, gc);
		
		//yes and no : the default is no
		ButtonGroup fillChoices = new ButtonGroup();
		
		gc.gridx = 0;
		gc.gridy = 30;
		JRadioButton yesToFill = new JRadioButton("Yes");
		fillChoices.add(yesToFill);
		toolbox.add(yesToFill, gc);
		
		gc.gridx = 1;
		gc.gridy = 30;
		JRadioButton noToFill = new JRadioButton("No");
		fillChoices.add(noToFill);
		toolbox.add(noToFill, gc);
		noToFill.setSelected(true);
		
		//the color for the fill function in case of yes
		gc.gridx = 0;
		gc.gridy = 31;
		JLabel fillColor = new JLabel("Fill color : ");
		toolbox.add(fillColor, gc);
		
		//hide before click
		fillColor.setVisible(false);

		gc.gridx = 1;
		gc.gridy = 31;
		JTextField fillColorValue = new JTextField(10);
		toolbox.add(fillColorValue, gc);
		
		//hide before click
		fillColorValue.setVisible(false);
		
		gc.gridx = 0;
		gc.gridy = 32;
		JButton addShape = new JButton("Add");
		addShape.setPreferredSize(new Dimension(10,10));
		toolbox.add(addShape, gc);
		
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

	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}

}
