package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Circle;
import view.GUI;

public class ControlCircleRadioBtn implements Observer, ActionListener {

	private Circle modele;
	private JLabel circleX;
	private	JTextField centerX;
	private	JLabel circleY;
	private	JTextField centerY;
	private	JLabel circleRadius;
	private	JTextField radiusValue;
	
	
	private GUI gui;
	
	//represents all the JLabel and JTextField of the GUI

	public ControlCircleRadioBtn(Circle modele, JLabel circleX, JTextField centerX, 
			JLabel circleY, JTextField centerY, JLabel circleRadius, JTextField radiusValue,
			GUI gui){
		this.modele = modele;
		this.circleX = circleX;
		this.centerX = centerX;
		this.circleY = circleY;
		this.centerY = centerY;
		this.circleRadius = circleRadius;
		this.radiusValue = radiusValue;
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.gui.hideComponents();
		//set visible the fields associated with Circle
		this.circleX.setVisible(true);
		this.centerX.setVisible(true);
		this.circleY.setVisible(true);
		this.centerY.setVisible(true);
		this.circleRadius.setVisible(true);
		this.radiusValue.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(centerX.getText()!=null) {
			this.modele.setCenter_x(Integer.parseInt(centerX.getText().trim()));
		}
		if(centerY.getText()!=null) {
			this.modele.setCenter_y(Integer.parseInt(centerY.getText().trim()));
		}
		if(radiusValue.getText()!=null){
			this.modele.setRadius(Integer.parseInt(radiusValue.getText().trim()));
		}
		
	}

}
