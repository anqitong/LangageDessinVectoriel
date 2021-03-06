package controller.guiController;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import model.specific_path.Polyline;

//controller for the "Add point" button under Polyline
public class ControlAddPointPolyline implements Observer, ActionListener{

	
	private Polyline modele;
	private JLabel xListPolylineValues;
	private JLabel yListPolylineValues; 
	private JTextField xInputPolylineValues;
	private JTextField yInputPolylineValues;
	
	public ControlAddPointPolyline(Polyline modele, JLabel xListPolylineValues, JLabel yListPolylineValues,
			JTextField xInputPolylineValues, JTextField yInputPolylineValues) {
		this.modele = modele;
		this.xListPolylineValues = xListPolylineValues;
		this.yListPolylineValues = yListPolylineValues;
		this.xInputPolylineValues = xInputPolylineValues;
		this.yInputPolylineValues = yInputPolylineValues;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.xInputPolylineValues.getText().equals("") && !this.yInputPolylineValues.equals("")){
			//fetch the new point
			Integer x = Integer.parseInt(xInputPolylineValues.getText().trim());
			Integer y = Integer.parseInt(yInputPolylineValues.getText().trim());
			Point point = new Point(x,y);
			ArrayList<Point> listPoints = this.modele.getPoints();
			
			//add the new point to the existing list of points
			listPoints.add(point);
			modele.setPoints(listPoints);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!this.xInputPolylineValues.getText().equals("") && !this.yInputPolylineValues.equals("")){
			Integer x = Integer.parseInt(xInputPolylineValues.getText().trim());
			Integer y = Integer.parseInt(yInputPolylineValues.getText().trim());
			String listX = this.xListPolylineValues.getText();
			String listY = this.yListPolylineValues.getText();
			listX+=x+";";
			listY+=y+";";
			//update the disply in the labels for the list of existing points
			this.xListPolylineValues.setText(listX);
			this.yListPolylineValues.setText(listY);
			
			//clear the fields
			this.xInputPolylineValues.setText("");
			this.yInputPolylineValues.setText("");
		}
	}

}
