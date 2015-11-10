package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * this class creates the graphical user interface for the svg drawing
 */
public class GUI extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7101648530122179966L;

	public GUI() throws IOException{
		super("Drawing interface");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container principal = this.getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(createLeftPart(), BorderLayout.WEST);
		principal.add(createRightPart(), BorderLayout.CENTER);
		this.pack();		
	}
	/*
	 * the right part contains the image display
	 */
	public JPanel createRightPart() throws IOException {

		JPanel right = new JPanel();
		right.setLayout(new BorderLayout());
		right.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

		//display the image
		BufferedImage image = ImageIO.read(new File("files"+File.separator+"image.png"));
		JLabel lab = new JLabel(new ImageIcon(image));

		right.add(lab, BorderLayout.CENTER) ;
		return right;
	}

	/*
	 * the left part contains the tool box and the console area
	 */
	public JPanel createLeftPart() {
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

		//add the tool box to the panel
		left.add(createToolBox()) ;

		//add the console to the panel
		left.add(createConsole());

		return left;
	}

	/**
	 * the tool box contains style and shape elements such as pencil,
	 * color, thickness, fill, circle, rectangle, ...
	 */
	public JPanel createToolBox() {
		JPanel toolbox = new JPanel();
		toolbox.setLayout(new BorderLayout());

		//the panel for the shapes and the style elements
		JPanel components = new JPanel();
		components.setLayout(new BoxLayout(components,BoxLayout.Y_AXIS));

		//Pencil and its style
		JLabel pencilStyle = new JLabel("Pencil style");
		components.add(pencilStyle);
		JButton pencilColor = new JButton("Pencil color");
		components.add(pencilColor);
		JButton pencilThickness = new JButton("Pencil thickness");
		components.add(pencilThickness);

		JSeparator sep1 = new JSeparator();
		components.add(sep1);

		//Shapes
		JLabel shapes = new JLabel("Shapes");
		components.add(shapes);

		JButton circle = new JButton("Circle");		
		components.add(circle);

		JButton ellipse = new JButton("Ellipse");
		components.add(ellipse);

		JButton line = new JButton("Line");
		components.add(line);

		JButton polygone = new JButton("Polygone");
		components.add(polygone);

		JButton polyline = new JButton("Polyline");
		components.add(polyline);

		JButton rectangle = new JButton("Rectangle");
		components.add(rectangle);

		JButton text = new JButton("Text");
		components.add(text);

		JSeparator sep2 = new JSeparator();
		components.add(sep2);

		//Fill and its options
		JLabel fill = new JLabel("Fill");
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no = new JRadioButton("no");
		ButtonGroup radioBtns = new ButtonGroup();
		JButton colorpicker = new JButton("Color picker");
		radioBtns.add(yes);
		radioBtns.add(no);
		components.add(fill);
		components.add(yes);
		components.add(no);
		components.add(colorpicker);


		toolbox.add(components,BorderLayout.CENTER);
		return toolbox;
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
		scrollPane.setPreferredSize(new Dimension(100,250));

		consoleArea.add(scrollPane);
		JButton pencil = new JButton("Run");

		pencil.setBackground(Color.RED);
		//		pencil.setFont(new Font("Arial",Font.BOLD,16));
		//		pencil.setForeground(Color.WHITE);
		pencil.setAlignmentX(LEFT_ALIGNMENT);

		consoleArea.add(pencil);

		return consoleArea;		
	}


	public static void main(String[] args) throws IOException {
		GUI gui = new GUI();
		gui.setVisible(true);
	}

}
