package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import model.specific_path.Ellipse;
import view.GUI;

//controller for the ellipse radio button
public class ControlEllipseRadioBtn implements Observer, ActionListener{

	private Ellipse modele;
	private JLabel ellipseCenterX;
	private JTextField ellipseCenterValueX;
	private JLabel ellipseCenterY;
	private JTextField ellipseCenterValueY;
	private JLabel ellipseRadiusX;
	private JTextField ellipseRadiusValueX;
	private JLabel ellipseRadiusY;
	private JTextField ellipseRadiusValueY;
	
	private GUI gui;


	public ControlEllipseRadioBtn(Ellipse modele, JLabel ellipseCenterX, JTextField ellipseCenterValueX,
			JLabel ellipseCenterY, JTextField ellipseCenterValueY, JLabel ellipseRadiusX,
			JTextField ellipseRadiusValueX, JLabel ellipseRadiusY, JTextField ellipseRadiusValueY,
			GUI gui) {
		this.modele = modele;
		this.ellipseCenterX = ellipseCenterX;
		this.ellipseCenterValueX = ellipseCenterValueX;
		this.ellipseCenterY = ellipseCenterY;
		this.ellipseCenterValueY = ellipseCenterValueY;
		this.ellipseRadiusX = ellipseRadiusX;
		this.ellipseRadiusValueX = ellipseRadiusValueX;
		this.ellipseRadiusY = ellipseRadiusY;
		this.ellipseRadiusValueY = ellipseRadiusValueY;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//hide the input fields of the all radio buttons
		this.gui.hideComponents();
		
		//set visible the input fields for ellipse
		this.ellipseCenterX.setVisible(true);
		this.ellipseCenterValueX.setVisible(true);
		this.ellipseCenterY.setVisible(true);
		this.ellipseCenterValueY.setVisible(true);
		this.ellipseRadiusX.setVisible(true);
		this.ellipseRadiusValueX.setVisible(true);
		this.ellipseRadiusY.setVisible(true);
		this.ellipseRadiusValueY.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
