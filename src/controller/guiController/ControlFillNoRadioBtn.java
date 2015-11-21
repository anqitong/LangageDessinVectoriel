package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

//controller for the "No" radio button in Fill Color section
public class ControlFillNoRadioBtn implements Observer, ActionListener{


	private JLabel fillRed;
	private JTextField fillRedValue;
	private JLabel fillGreen;
	private JTextField fillGreenValue;
	private JLabel fillBlue;
	private JTextField fillBlueValue;
	
	public ControlFillNoRadioBtn(JLabel fillRed, JTextField fillRedValue, JLabel fillGreen, JTextField fillGreenValue,
			JLabel fillBlue, JTextField fillBlueValue) {
		this.fillRed = fillRed;
		this.fillRedValue = fillRedValue;
		this.fillGreen = fillGreen;
		this.fillGreenValue = fillGreenValue;
		this.fillBlue = fillBlue;
		this.fillBlueValue = fillBlueValue;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//set invisible the input fields
		fillRed.setVisible(false);
		fillRedValue.setVisible(false);
		fillGreen.setVisible(false);
		fillGreenValue.setVisible(false);
		fillBlue.setVisible(false);
		fillBlueValue.setVisible(false);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
