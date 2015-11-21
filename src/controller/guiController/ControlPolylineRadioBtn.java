package controller.guiController;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Polyline;
import view.GUI;

//controller for the "Polyline" radio button
public class ControlPolylineRadioBtn implements Observer, ActionListener{

	private Polyline modele;
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
	
	
	public ControlPolylineRadioBtn(Polyline modele, JLabel xListPolyline, JLabel xListPolylineValues,
			JLabel yListPolyline, JLabel yListPolylineValues, JLabel xInputPolyline, JTextField xInputPolylineValue,
			JLabel yInputPolyline, JTextField yInputPolylineValue, JButton addPointPolyline, GUI gui) {
		this.modele = modele;
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
	}

	@Override
	public void update(Observable o, Object arg) {
//		ArrayList<Point> liste = this.modele.getPoints();
//		if(liste!=null && liste.size()>0){
//			String xList = "";
//			String yList = "";
//			for(int i = 0;i<liste.size();i++){
//				xList+=liste.get(i).getX()+";";
//				yList+=liste.get(i).getY()+";";
//			}
//			this.xListPolylineValues.setText(xList);
//			this.yListPolylineValues.setText(yList);
//		}
	}

}
