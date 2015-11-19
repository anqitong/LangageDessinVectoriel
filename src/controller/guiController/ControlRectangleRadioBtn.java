package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Rectangle;
import view.GUI;

public class ControlRectangleRadioBtn implements Observer, ActionListener{
	

	private Rectangle modele;
	private GUI gui;
	
	private JLabel rectX;
	private JTextField rectValueX;
	private JLabel rectY;
	private JTextField rectValueY;
	private JLabel rectWidth;
	private JTextField rectWidthValue;
	private JLabel rectHeight;
	private JTextField rectHeightValue;
	
	public ControlRectangleRadioBtn(Rectangle modele, JLabel rectX, JTextField rectValueX, JLabel rectY,
			JTextField rectValueY, JLabel rectWidth, JTextField rectWidthValue, JLabel rectHeight,
			JTextField rectHeightValue, GUI gui) {
		this.modele = modele;
		this.rectX = rectX;
		this.rectValueX = rectValueX;
		this.rectY = rectY;
		this.rectValueY = rectValueY;
		this.rectWidth = rectWidth;
		this.rectWidthValue = rectWidthValue;
		this.rectHeight = rectHeight;
		this.rectHeightValue = rectHeightValue;
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.gui.hideComponents();
		
		rectX.setVisible(true);
		rectValueX.setVisible(true);
		rectY.setVisible(true);
		rectValueY.setVisible(true);
		rectWidth.setVisible(true);
		rectWidthValue.setVisible(true);
		rectHeight.setVisible(true);
		rectHeightValue.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(rectValueX.getText()!=null){
			this.modele.setX(Integer.parseInt(rectValueX.getText().trim()));
		}
		if(rectValueY.getText()!=null){
			this.modele.setY(Integer.parseInt(rectValueY.getText().trim()));
		}
		if(rectWidthValue.getText()!=null){
			this.modele.setWidth(Integer.parseInt(rectWidthValue.getText().trim()));
		}
		if(rectHeightValue.getText()!=null){
			this.modele.setHeight(Integer.parseInt(rectHeightValue.getText().trim()));
		}
	}

}
