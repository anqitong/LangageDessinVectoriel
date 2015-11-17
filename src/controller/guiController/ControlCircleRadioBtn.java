package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Circle;

public class ControlCircleRadioBtn implements Observer, ActionListener {

	private Circle modele;
	private JLabel circleX;
	private	JTextField centerX;
	private	JLabel circleY;
	private	JTextField centerY;
	private	JLabel circleRadius;
	private	JTextField radiusValue;

	public ControlCircleRadioBtn(Circle modele, JLabel circleX, JTextField centerX, 
			JLabel circleY, JTextField centerY, JLabel circleRadius, JTextField radiusValue){
		this.modele = modele;
		this.circleX = circleX;
		this.centerX = centerX;
		this.circleY = circleY;
		this.centerY = centerY;
		this.circleRadius = circleRadius;
		this.radiusValue = radiusValue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.circleX.setVisible(!this.circleX.isVisible());
		this.centerX.setVisible(!this.centerX.isVisible());
		this.circleY.setVisible(!this.circleY.isVisible());
		this.centerY.setVisible(!this.centerY.isVisible());
		this.circleRadius.setVisible(!this.circleRadius.isVisible());
		this.radiusValue.setVisible(!this.radiusValue.isVisible());
	}

	@Override
	public void update(Observable o, Object arg) {
//		if(centerX.getText()!=null) {
//			this.modele.setCenter_x(Integer.parseInt(centerX.getText().trim()));
//		}
		
	}

}
