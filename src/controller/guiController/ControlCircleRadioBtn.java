package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import view.GUI;

//controller for the radio button "circle3
public class ControlCircleRadioBtn implements Observer, ActionListener {

	private JLabel circleX;
	private	JTextField centerX;
	private	JLabel circleY;
	private	JTextField centerY;
	private	JLabel circleRadius;
	private	JTextField radiusValue;
	private GUI gui;
	private JRadioButton yesToFill;
	private JRadioButton noToFill;
	
	
	
	//represents all the JLabel and JTextField of the GUI

	public ControlCircleRadioBtn(JLabel circleX, JTextField centerX, 
			JLabel circleY, JTextField centerY, JLabel circleRadius, JTextField radiusValue,
			GUI gui, JRadioButton yesToFill, JRadioButton noToFill){
		this.circleX = circleX;
		this.centerX = centerX;
		this.circleY = circleY;
		this.centerY = centerY;
		this.circleRadius = circleRadius;
		this.radiusValue = radiusValue;
		this.gui = gui;
		this.yesToFill = yesToFill;
		this.noToFill = noToFill;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//hide the fields under the other radio buttons
		this.gui.hideComponents();

		//set visible the fields associated with Circle
		this.circleX.setVisible(true);
		this.centerX.setVisible(true);
		this.circleY.setVisible(true);
		this.centerY.setVisible(true);
		this.circleRadius.setVisible(true);
		this.radiusValue.setVisible(true);
		
		//enable radio buttons for fill color
		this.yesToFill.setEnabled(true);
		this.noToFill.setEnabled(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
