package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame{

	public GUI() throws IOException{
		super("Drawing interface");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container principal = this.getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(createLeftPart(), BorderLayout.WEST);
		principal.add(createRightPart(), BorderLayout.CENTER);
		this.pack();		
	}

	public JPanel createRightPart() throws IOException {
		JPanel drawing = new JPanel();
		drawing.setLayout(new BorderLayout());
		drawing.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

		BufferedImage image = ImageIO.read(new File("files"+File.separator+"image.png"));
		JLabel lab = new JLabel(new ImageIcon(image));
		drawing.add(lab, BorderLayout.CENTER) ;
		return drawing;
	}

	public JPanel createLeftPart() {
		JPanel panelGauche = new JPanel();
		panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
		panelGauche.add( createToolBox()) ;
		panelGauche.add( createConsole());
		return panelGauche;
	}

	public JPanel createToolBox() {
		JPanel toolbox = new JPanel();
		toolbox.setLayout(new BorderLayout());
		// on peut egalement utiliser un BoxLayout et ajouter une glue avant d'ajouter le label. new BoxLayout(toolbox, BoxLayout.X_AXIS));
		JPanel touches = new JPanel();
		touches.setLayout(new BoxLayout(touches,BoxLayout.Y_AXIS));
		JButton pencil = new JButton("Pencil");
		pencil.setBackground(Color.RED);
		pencil.setFont(new Font("Arial",Font.BOLD,16));
		pencil.setForeground(Color.WHITE);
		touches.add(pencil, BorderLayout.WEST);

		JButton fill = new JButton("Fill");
		fill.setBackground(Color.RED);
		fill.setFont(new Font("Arial",Font.BOLD,16));
		fill.setForeground(Color.WHITE);
		touches.add(fill, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton circle = new JButton("Circle");
		circle.setBackground(Color.RED);
		circle.setFont(new Font("Arial",Font.BOLD,16));
		circle.setForeground(Color.WHITE);
		touches.add(circle, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton ellipse = new JButton("Ellipse");
		ellipse.setBackground(Color.RED);
		ellipse.setFont(new Font("Arial",Font.BOLD,16));
		ellipse.setForeground(Color.WHITE);
		touches.add(ellipse, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton line = new JButton("Line");
		line.setBackground(Color.RED);
		line.setFont(new Font("Arial",Font.BOLD,16));
		line.setForeground(Color.WHITE);
		touches.add(line, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton polygone = new JButton("Polygone");
		polygone.setBackground(Color.RED);
		polygone.setFont(new Font("Arial",Font.BOLD,16));
		polygone.setForeground(Color.WHITE);
		touches.add(polygone, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton polyline = new JButton("Polyline");
		polyline.setBackground(Color.RED);
		polyline.setFont(new Font("Arial",Font.BOLD,16));
		polyline.setForeground(Color.WHITE);
		touches.add(polyline, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton rectangle = new JButton("Rectangle");
		rectangle.setBackground(Color.RED);
		rectangle.setFont(new Font("Arial",Font.BOLD,16));
		rectangle.setForeground(Color.WHITE);
		touches.add(rectangle, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		JButton text = new JButton("Text");
		text.setBackground(Color.RED);
		text.setFont(new Font("Arial",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		touches.add(text, BorderLayout.EAST);
		toolbox.add(touches, BorderLayout.WEST);

		//toolbox.setMaximumSize(new Dimension(2000,50));
		return toolbox;
	}

	public JPanel createConsole() {
		JPanel input = new JPanel();
		JTextArea area = new JTextArea("Some commands ....");
		input.add(area);
		input.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		input.setLayout(new GridLayout(5,4));

		//		JButton toucheMC = new JButton("MC");
		//		toucheMC.setFont(new Font("Arial",Font.BOLD,16));
		//		toucheMC.setBackground(Color.BLUE);
		//		toucheMC.setForeground(Color.WHITE);
		//		input.add(toucheMC);

		return input;		
	}

	public static void main(String[] args) throws IOException {
		GUI gui = new GUI();
		gui.setVisible(true);
	}

}
