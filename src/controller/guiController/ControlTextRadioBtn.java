package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.GUI;

//controller for the "text" radio button
public class ControlTextRadioBtn implements Observer, ActionListener{

	private JLabel textX;
	private JTextField textValueX;
	private JLabel textY;
	private JTextField textValueY;
	private JLabel textValueLabel;
	private JTextField textValue;
	private GUI gui;
	
	private JRadioButton yesToFill;
	private JRadioButton noToFill;


	public ControlTextRadioBtn(JLabel textX, JTextField textValueX, JLabel textY, JTextField textValueY,
			JLabel textValueLabel, JTextField textValue, GUI gui, JRadioButton yesToFill,
			JRadioButton noToFill) {
		this.textX = textX;
		this.textValueX = textValueX;
		this.textY = textY;
		this.textValueY = textValueY;
		this.textValueLabel = textValueLabel;
		this.textValue = textValue;
		this.gui = gui;
		this.yesToFill = yesToFill;
		this.noToFill = noToFill;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//hide the input fields of all the shape elements
		this.gui.hideComponents();

		//set visible the input fields for text
		this.textX.setVisible(true);
		this.textValueX.setVisible(true);
		this.textY.setVisible(true);
		this.textValueY.setVisible(true);
		this.textValueLabel.setVisible(true);
		this.textValue.setVisible(true);
		
		//disable radio buttons for fill color
		this.yesToFill.setEnabled(false);
		this.noToFill.setEnabled(false);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
