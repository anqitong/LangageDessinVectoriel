package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ColorSVG;
import model.Pencil;
import model.specific_path.Circle;

public class AddToConsoleController implements Observer, ActionListener{

	//Pencil
	private Pencil pencil;
	private JTextField pencilColorValue;
	private JTextField thicknessValue;
	
	//Circle
	private Circle circle;
	private	JTextField centerX;
	private	JTextField centerY;
	private	JTextField radiusValue;
	
	public AddToConsoleController(Pencil pencil, JTextField pencilColorValue, 
			JTextField thicknessValue, Circle circle,
			JTextField centerX, JTextField centerY, JTextField radiusValue){
		this.pencil = pencil;
		this.pencilColorValue = pencilColorValue;
		this.thicknessValue = thicknessValue;
		this.circle = circle;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radiusValue = radiusValue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(this.pencilColorValue.getText()!=null){
			Integer colorSVG = Integer.parseInt(pencilColorValue.getText().trim());
			pencil.setColor(new ColorSVG(colorSVG));
		}
		if(this.thicknessValue.getText()!=null){
			Integer width = Integer.parseInt(thicknessValue.getText().trim());
			pencil.setWidth(width);
		}
		
		if(centerX.getText()!=null) {
			this.circle.setCenter_x(Integer.parseInt(centerX.getText().trim()));
		}
		if(centerY.getText()!=null) {
			this.circle.setCenter_y(Integer.parseInt(centerY.getText().trim()));
		}
		if(radiusValue.getText()!=null){
			this.circle.setRadius(Integer.parseInt(radiusValue.getText().trim()));
		}
		
		circle.setPencil(pencil);
		
		
		
	}

}
