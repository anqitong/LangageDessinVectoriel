package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.GUI;

//controller for the "Line" radio button in shapes section
public class ControlLineRadioBtn implements Observer, ActionListener{

	private JLabel x1;
	private JTextField x1Value;
	private JLabel y1;
	private JTextField y1Value;
	private JLabel x2;
	private JTextField x2Value;
	private JLabel y2;
	private JTextField y2Value;
	private JRadioButton yesToFill;
	private JRadioButton noToFill;
	
	private GUI gui;
	
	public ControlLineRadioBtn(JLabel x1, JTextField x1Value, JLabel y1, JTextField y1Value, JLabel x2,
			JTextField x2Value, JLabel y2, JTextField y2Value, GUI gui, JRadioButton yesToFill,
			JRadioButton noToFill) {
		this.x1 = x1;
		this.x1Value = x1Value;
		this.y1 = y1;
		this.y1Value = y1Value;
		this.x2 = x2;
		this.x2Value = x2Value;
		this.y2 = y2;
		this.y2Value = y2Value;
		this.gui = gui;
		this.yesToFill = yesToFill;
		this.noToFill = noToFill;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//hide the input fields of all the shapes
		this.gui.hideComponents();
		
		//set visibles input fields for Line
		this.x1.setVisible(true);
		this.x1Value.setVisible(true);
		this.y1.setVisible(true);
		this.y1Value.setVisible(true);
		this.x2.setVisible(true);
		this.x2Value.setVisible(true);
		this.y2.setVisible(true);
		this.y2Value.setVisible(true);
		
		//disable radio buttons for fill color
		this.yesToFill.setEnabled(false);
		this.noToFill.setEnabled(false);
		
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
