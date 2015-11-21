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

import model.specific_path.Polygone;
import view.GUI;

//controller for the "Polygone" radio button
public class ControlPolygoneRadioBtn implements Observer, ActionListener{
	
	private Polygone modele;
	private JLabel xListPolygone;
	private JLabel xListPolygoneValues;
	private JLabel yListPolygone;
	private JLabel yListPolygoneValues;
	private JLabel xInputPolygone;
	private JTextField xInputPolygoneValue;
	private JLabel yInputPolygone;
	private JTextField yInputPolygoneValue;
	private JButton addPointPolygone;
	private GUI gui;
	
	
	public ControlPolygoneRadioBtn(Polygone modele, JLabel xListPolygone, JLabel xListPolygoneValues,
			JLabel yListPolygone, JLabel yListPolygoneValues, JLabel xInputPolygone, JTextField xInputPolygoneValue,
			JLabel yInputPolygone, JTextField yInputPolygoneValue, JButton addPointPolygone,GUI gui) {
		this.modele = modele;
		this.xListPolygone = xListPolygone;
		this.xListPolygoneValues = xListPolygoneValues;
		this.yListPolygone = yListPolygone;
		this.yListPolygoneValues = yListPolygoneValues;
		this.xInputPolygone = xInputPolygone;
		this.xInputPolygoneValue = xInputPolygoneValue;
		this.yInputPolygone = yInputPolygone;
		this.yInputPolygoneValue = yInputPolygoneValue;
		this.addPointPolygone = addPointPolygone;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//hide all the input fields of all the shapes
		this.gui.hideComponents();
		
		//set visibles the input fields of Polygone
		this.xListPolygone.setVisible(true);
		this.xListPolygoneValues.setVisible(true);
		this.yListPolygone.setVisible(true);
		this.yListPolygoneValues.setVisible(true);
		this.xInputPolygone.setVisible(true);
		this.xInputPolygoneValue.setVisible(true);
		this.yInputPolygone.setVisible(true);
		this.yInputPolygoneValue.setVisible(true);
		this.addPointPolygone.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		ArrayList<Point> liste = this.modele.getPoints();
		if(liste!=null && liste.size()>0){
			String xList = "";
			String yList = "";
			for(int i = 0;i<liste.size();i++){
				xList+=liste.get(i).getX()+";";
				yList+=liste.get(i).getY()+";";
			}
			this.xListPolygoneValues.setText(xList);
			this.yListPolygoneValues.setText(yList);
		}
	}

}
