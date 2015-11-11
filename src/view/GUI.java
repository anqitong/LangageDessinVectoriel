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
		//toolbox.setLayout(new BorderLayout());
		toolbox.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 3;
		gc.weighty = 13;
		
		//line 1
		gc.gridx = 0;
		gc.gridy = 0;
		JLabel pencilStyle = new JLabel("Pencil style");
		toolbox.add(pencilStyle, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		JLabel pencilColor = new JLabel("Pencil color");
		toolbox.add(pencilColor, gc);
		
		//line 2
		gc.gridx = 1;
		gc.gridy = 1;
		JTextField pencilColorValue = new JTextField(10);
		toolbox.add(pencilColorValue, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		JLabel pencilThickness = new JLabel("Pencil thickness");
		toolbox.add(pencilThickness, gc);
		
		//line 3
		gc.gridx = 1;
		gc.gridy = 2;
		JTextField thicknessValue = new JTextField(10);
		toolbox.add(thicknessValue, gc);
		
		//line 4
		gc.gridx = 0;
		gc.gridy = 3;
		JLabel shapes = new JLabel("Shapes");
		toolbox.add(shapes, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		JButton circle = new JButton("Circle");
		toolbox.add(circle, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		JButton ellipse = new JButton("Ellipse");
		toolbox.add(ellipse, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		JButton line = new JButton("Line");
		toolbox.add(line, gc);
		
		gc.gridx = 0;
		gc.gridy = 7;
		JButton polygone = new JButton("Polygone");
		toolbox.add(polygone, gc);
		
		gc.gridx = 0;
		gc.gridy = 8;
		JButton polyline = new JButton("Polyline");
		toolbox.add(polyline, gc);

		gc.gridx = 0;
		gc.gridy = 9;
		JButton rectangle = new JButton("Rectangle");
		toolbox.add(rectangle, gc);
		
		gc.gridx = 0;
		gc.gridy = 10;
		JButton text = new JButton("Text");
		toolbox.add(text, gc);
		
		gc.gridx = 0;
		gc.gridy = 11;
		JLabel fill = new JLabel("Fill");
		toolbox.add(fill, gc);
		
		gc.gridx = 1;
		gc.gridy = 11;
		JRadioButton yes = new JRadioButton("Yes");
		toolbox.add(yes, gc);
		
		gc.gridx = 2;
		gc.gridy = 11;
		JRadioButton no = new JRadioButton("no");
		toolbox.add(no, gc);
		
		ButtonGroup radioBtns = new ButtonGroup();
		radioBtns.add(yes);
		radioBtns.add(no);
		
		gc.gridx = 0;
		gc.gridy = 12;
		JButton colorpicker = new JButton("Color picker");
		toolbox.add(colorpicker, gc);

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

		//pencil.setBackground(Color.RED);
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
