package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

//controller for the "yes" radio button under the fill color section
public class ControlFillYesRadioBtn implements Observer, ActionListener{


	private JLabel fillRed;
	private JTextField fillRedValue;
	private JLabel fillGreen;
	private JTextField fillGreenValue;
	private JLabel fillBlue;
	private JTextField fillBlueValue;
	
	public ControlFillYesRadioBtn(JLabel fillRed, JTextField fillRedValue, JLabel fillGreen, JTextField fillGreenValue,
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
		
		//set visible the input fields for the fill color
		fillRed.setVisible(true);
		fillRedValue.setVisible(true);
		fillGreen.setVisible(true);
		fillGreenValue.setVisible(true);
		fillBlue.setVisible(true);
		fillBlueValue.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
