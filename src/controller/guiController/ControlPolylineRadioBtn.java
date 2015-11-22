package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.GUI;

//controller for the "Polyline" radio button
public class ControlPolylineRadioBtn implements Observer, ActionListener{

	private JLabel xListPolyline;
	private JLabel xListPolylineValues;
	private JLabel yListPolyline;
	private JLabel yListPolylineValues;
	private JLabel xInputPolyline;
	private JTextField xInputPolylineValue;
	private JLabel yInputPolyline;
	private JTextField yInputPolylineValue;
	private JButton addPointPolyline;
	private GUI gui;
	private JRadioButton yesToFill;
	private JRadioButton noToFill;
	
	
	
	public ControlPolylineRadioBtn(JLabel xListPolyline, JLabel xListPolylineValues,
			JLabel yListPolyline, JLabel yListPolylineValues, JLabel xInputPolyline, JTextField xInputPolylineValue,
			JLabel yInputPolyline, JTextField yInputPolylineValue, JButton addPointPolyline, GUI gui,
			JRadioButton yesToFill, JRadioButton noToFill) {
		this.xListPolyline = xListPolyline;
		this.xListPolylineValues = xListPolylineValues;
		this.yListPolyline = yListPolyline;
		this.yListPolylineValues = yListPolylineValues;
		this.xInputPolyline = xInputPolyline;
		this.xInputPolylineValue = xInputPolylineValue;
		this.yInputPolyline = yInputPolyline;
		this.yInputPolylineValue = yInputPolylineValue;
		this.addPointPolyline = addPointPolyline;
		this.gui = gui;
		this.yesToFill = yesToFill;
		this.noToFill = noToFill;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//hide the input fields of all the shape elements
		this.gui.hideComponents();
		
		//set visible input fields for Poyline
		this.xListPolyline.setVisible(true);
		this.xListPolylineValues.setVisible(true);
		this.xListPolylineValues.setVisible(true);
		this.yListPolyline.setVisible(true);
		this.yListPolylineValues.setVisible(true);
		this.xInputPolyline.setVisible(true);
		this.xInputPolylineValue.setVisible(true);
		this.yInputPolyline.setVisible(true);
		this.yInputPolylineValue.setVisible(true);
		this.addPointPolyline.setVisible(true);
		
		//disable radio buttons for fill color
		this.yesToFill.setEnabled(false);
		this.noToFill.setEnabled(false);
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
