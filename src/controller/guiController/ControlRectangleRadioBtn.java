package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.specific_path.Rectangle;
import view.GUI;

//controller for "Rectangle" radio button
public class ControlRectangleRadioBtn implements Observer, ActionListener{
	

	private GUI gui;
	
	private JLabel rectX;
	private JTextField rectValueX;
	private JLabel rectY;
	private JTextField rectValueY;
	private JLabel rectWidth;
	private JTextField rectWidthValue;
	private JLabel rectHeight;
	private JTextField rectHeightValue;
	private JRadioButton yesToFill;
	private JRadioButton noToFill;
	
	public ControlRectangleRadioBtn(JLabel rectX, JTextField rectValueX, JLabel rectY,
			JTextField rectValueY, JLabel rectWidth, JTextField rectWidthValue, JLabel rectHeight,
			JTextField rectHeightValue, GUI gui, JRadioButton yesToFill,
			JRadioButton noToFill) {
		this.rectX = rectX;
		this.rectValueX = rectValueX;
		this.rectY = rectY;
		this.rectValueY = rectValueY;
		this.rectWidth = rectWidth;
		this.rectWidthValue = rectWidthValue;
		this.rectHeight = rectHeight;
		this.rectHeightValue = rectHeightValue;
		this.gui = gui;
		this.yesToFill = yesToFill;
		this.noToFill = noToFill;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//hide all the input fields in shape section
		this.gui.hideComponents();
		
		//set visible input fields for rectangle
		rectX.setVisible(true);
		rectValueX.setVisible(true);
		rectY.setVisible(true);
		rectValueY.setVisible(true);
		rectWidth.setVisible(true);
		rectWidthValue.setVisible(true);
		rectHeight.setVisible(true);
		rectHeightValue.setVisible(true);
		
		//enable radio buttons for fill color
		this.yesToFill.setEnabled(true);
		this.noToFill.setEnabled(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
