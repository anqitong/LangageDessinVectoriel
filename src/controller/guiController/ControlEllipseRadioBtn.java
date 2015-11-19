package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import model.specific_path.Ellipse;
import view.GUI;

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

	//represents all the JLabel and JTextField of the GUI
	//private HashMap<String,JComponent> map;

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
//		this.list = new ArrayList<String>();
//		this.list.add("ellipseCenterX");
//		this.list.add("ellipseCenterValueX");
//		this.list.add("ellipseCenterY");
//		this.list.add("ellipseCenterValueY");
//		this.list.add("ellipseRadiusX");
//		this.list.add("ellipseRadiusValueX");
//		this.list.add("ellipseRadiusY");
//		this.list.add("ellipseRadiusValueY");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gui.hideComponents();
		this.ellipseCenterX.setVisible(true);
		this.ellipseCenterValueX.setVisible(true);
		this.ellipseCenterY.setVisible(true);
		this.ellipseCenterValueY.setVisible(true);
		this.ellipseRadiusX.setVisible(true);
		this.ellipseRadiusValueX.setVisible(true);
		this.ellipseRadiusY.setVisible(true);
		this.ellipseRadiusValueY.setVisible(true);
		
//		this.gui.setToHide(list);
		/*
		map.remove("ellipseCenterX");
		map.remove("ellipseCenterValueX");
		map.remove("ellipseCenterY");
		map.remove("ellipseCenterValueY");
		map.remove("ellipseRadiusX");
		map.remove("ellipseRadiusValueX");
		map.remove("ellipseRadiusY");
		map.remove("ellipseRadiusValueY");

		//all the other label and text fields are set invisible
		Iterator<Map.Entry<String,JComponent>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, JComponent> entry = iterator.next();
			entry.getValue().setVisible(false);
		}*/
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}


}
