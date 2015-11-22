package controller.guiController;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Polygone;

public class ControlAddPointPolygone implements Observer, ActionListener{
	
	private Polygone modele;
	private JLabel xListPolygoneValues;
	private JLabel yListPolygoneValues; 
	private JTextField xInputPolygoneValues;
	private JTextField yInputPolygoneValues;
	
	//controller for the "Add point" button under Polygone
	public ControlAddPointPolygone(Polygone modele, JLabel xListPolygoneValues, JLabel yListPolygoneValues,
			JTextField xInputPolygoneValues, JTextField yInputPolygoneValues) {
		this.modele = modele;
		this.xListPolygoneValues = xListPolygoneValues;
		this.yListPolygoneValues = yListPolygoneValues;
		this.xInputPolygoneValues = xInputPolygoneValues;
		this.yInputPolygoneValues = yInputPolygoneValues;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.xInputPolygoneValues.getText().equals("") && !this.yInputPolygoneValues.equals("")){
			//fetch the new point from the input values
			Integer x = Integer.parseInt(xInputPolygoneValues.getText().trim());
			Integer y = Integer.parseInt(yInputPolygoneValues.getText().trim());
			Point point = new Point(x,y);
			ArrayList<Point> listPoints = this.modele.getPoints();
			
			//add the new point to the list
			listPoints.add(point);
			modele.setPoints(listPoints);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(!this.xInputPolygoneValues.getText().equals("") && !this.yInputPolygoneValues.equals("")){
			Integer x = Integer.parseInt(xInputPolygoneValues.getText().trim());
			Integer y = Integer.parseInt(yInputPolygoneValues.getText().trim());
			String listX = this.xListPolygoneValues.getText();
			String listY = this.yListPolygoneValues.getText();
			
			//display the new points in the labels
			listX+=x+";";
			listY+=y+";";
			this.xListPolygoneValues.setText(listX);
			this.yListPolygoneValues.setText(listY);
			
			//clear the fields
			this.xInputPolygoneValues.setText("");
			this.yInputPolygoneValues.setText("");
			
		}
	}

}
