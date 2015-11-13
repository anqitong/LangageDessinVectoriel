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
		//add the tool box to the panel
//		left.add(createToolBox()) ;
		
		//add the console to the panel
//		left.add(createConsole());

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
		gc.gridx = 0;
		gc.gridy = 3;
		JLabel shapes = new JLabel("Shapes");
		shapes.setFont(new Font("Label.font",Font.BOLD,15));
		toolbox.add(shapes, gc);
		
		//Circle  : center and radius values
		gc.gridx = 0;
		gc.gridy = 4;
		JButton circle = new JButton("Circle");
		circle.setPreferredSize(new Dimension(10,10));
		toolbox.add(circle, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		JLabel circleX = new JLabel("Center X : ");
		toolbox.add(circleX, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		JTextField centerX = new JTextField(3);
		toolbox.add(centerX, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		JLabel circleY = new JLabel("Center Y : ");
		toolbox.add(circleY, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		JTextField centerY = new JTextField(3);
		toolbox.add(centerY, gc);
		
		gc.gridx = 0;
		gc.gridy = 7;
		JLabel circleRadius = new JLabel("Circle radius : ");
		toolbox.add(circleRadius, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		JTextField radiusValue = new JTextField(3);
		toolbox.add(radiusValue, gc);
		
		
		//Ellipse : center and radius values
		gc.gridx = 0;
		gc.gridy = 8;
		JButton ellipse = new JButton("Ellipse");
		ellipse.setPreferredSize(new Dimension(10,10));
		toolbox.add(ellipse, gc);
		
		gc.gridx = 0;
		gc.gridy = 9;
		JLabel ellipseCenterX = new JLabel("Ellipse center X : ");
		toolbox.add(ellipseCenterX, gc);
		
		gc.gridx = 1;
		gc.gridy = 9;
		JTextField ellipseCenterValueX =  new JTextField(5);
		toolbox.add(ellipseCenterValueX, gc);
		
		gc.gridx = 0;
		gc.gridy = 10;
		JLabel ellipseCenterY = new JLabel("Ellipse center Y : ");
		toolbox.add(ellipseCenterY, gc);
		
		gc.gridx = 1;
		gc.gridy = 10;
		JTextField ellipseCenterValueY =  new JTextField(5);
		toolbox.add(ellipseCenterValueY, gc);
		
		gc.gridx = 0;
		gc.gridy = 11;
		JLabel ellipseRadiusX = new JLabel("Ellipse radius X : ");
		toolbox.add(ellipseRadiusX, gc);
		
		gc.gridx = 1;
		gc.gridy = 11;
		JTextField ellipseRadiusValueX =  new JTextField(5);
		toolbox.add(ellipseRadiusValueX, gc);
		
		gc.gridx = 0;
		gc.gridy = 12;
		JLabel ellipseRadiusY = new JLabel("Ellipse radius Y : ");
		toolbox.add(ellipseRadiusY, gc);
		
		gc.gridx = 1;
		gc.gridy = 12;
		JTextField ellipseRadiusValueY =  new JTextField(5);
		toolbox.add(ellipseRadiusValueY, gc);
		
		//Line and its points
		gc.gridx = 0;
		gc.gridy = 13;
		JButton line = new JButton("Line");
		line.setPreferredSize(new Dimension(10,10));
		toolbox.add(line, gc);
		
		gc.gridx = 0;
		gc.gridy = 14;
		JLabel x1 = new JLabel("x1 : ");
		toolbox.add(x1, gc);
		
		gc.gridx = 1;
		gc.gridy = 14;
		JTextField x1Value = new JTextField(5);
		toolbox.add(x1Value, gc);
		
		gc.gridx = 0;
		gc.gridy = 15;
		JLabel y1 = new JLabel("y1 : ");
		toolbox.add(y1, gc);
		
		gc.gridx = 1;
		gc.gridy = 15;
		JTextField y1Value = new JTextField(5);
		toolbox.add(y1Value, gc);
		
		gc.gridx = 0;
		gc.gridy = 16;
		JLabel x2 = new JLabel("x2 : ");
		toolbox.add(x2, gc);
		
		gc.gridx = 1;
		gc.gridy = 16;
		JTextField x2Value = new JTextField(5);
		toolbox.add(x2Value, gc);
		
		gc.gridx = 0;
		gc.gridy = 17;
		JLabel y2 = new JLabel("y2 : ");
		toolbox.add(y2, gc);
		
		gc.gridx = 1;
		gc.gridy = 17;
		JTextField y2Value = new JTextField(5);
		toolbox.add(y2Value, gc);
		
		
		//Polygone
		gc.gridx = 0;
		gc.gridy = 18;
		JButton polygone = new JButton("Polygone");
		polygone.setPreferredSize(new Dimension(10,10));
		toolbox.add(polygone, gc);
		
		//Polyline
		gc.gridx = 0;
		gc.gridy = 19;
		JButton polyline = new JButton("Polyline");
		polyline.setPreferredSize(new Dimension(10,10));
		toolbox.add(polyline, gc);

		//Rectangle and its values
		gc.gridx = 0;
		gc.gridy = 20;
		JButton rectangle = new JButton("Rectangle");
		rectangle.setPreferredSize(new Dimension(10,10));
		toolbox.add(rectangle, gc);
		
		gc.gridx = 0;
		gc.gridy = 21;
		JLabel rectX = new JLabel("Rectangle X : ");
		toolbox.add(rectX, gc);
		
		gc.gridx = 1;
		gc.gridy = 21;
		JTextField rectValueX = new JTextField(10);
		toolbox.add(rectValueX, gc);
		
		gc.gridx = 0;
		gc.gridy = 22;
		JLabel rectY = new JLabel("Rectangle Y : ");
		toolbox.add(rectY, gc);
		
		gc.gridx = 1;
		gc.gridy = 22;
		JTextField rectValueY = new JTextField(10);
		toolbox.add(rectValueY, gc);
		
		gc.gridx = 0;
		gc.gridy = 23;
		JLabel rectWidth = new JLabel("Rectangle width : ");
		toolbox.add(rectWidth, gc);
		
		gc.gridx = 1;
		gc.gridy = 23;
		JTextField rectWidthValue = new JTextField(10);
		toolbox.add(rectWidthValue, gc);
		
		gc.gridx = 0;
		gc.gridy = 24;
		JLabel rectHeight = new JLabel("Rectangle height : ");
		toolbox.add(rectHeight, gc);
		
		gc.gridx = 1;
		gc.gridy = 24;
		JTextField rectHeightValue = new JTextField(10);
		toolbox.add(rectHeightValue, gc);
		
		//Text and its values
		gc.gridx = 0;
		gc.gridy = 25;
		JButton text = new JButton("Text");
		text.setPreferredSize(new Dimension(10,10));
		toolbox.add(text, gc);
		
		gc.gridx = 0;
		gc.gridy = 26;
		JLabel textX = new JLabel("Text X : ");
		toolbox.add(textX, gc);
		
		gc.gridx = 1;
		gc.gridy = 26;
		JTextField textValueX = new JTextField(10);
		toolbox.add(textValueX, gc);
		
		gc.gridx = 0;
		gc.gridy = 27;
		JLabel textY = new JLabel("Text Y : ");
		toolbox.add(textY, gc);
		
		gc.gridx = 1;
		gc.gridy = 27;
		JTextField textValueY = new JTextField(10);
		toolbox.add(textValueY, gc);
		
		gc.gridx = 0;
		gc.gridy = 28;
		JLabel textValueLabel = new JLabel("Text value : ");
		toolbox.add(textValueLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 28;
		JTextField textValue = new JTextField(10);
		toolbox.add(textValue, gc);
		
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
