package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Line;
import view.GUI;

public class ControlLineRadioBtn implements Observer, ActionListener{

	

	private Line modele;
	private JLabel x1;
	private JTextField x1Value;
	private JLabel y1;
	private JTextField y1Value;
	private JLabel x2;
	private JTextField x2Value;
	private JLabel y2;
	private JTextField y2Value;
	
	private GUI gui;
	
	public ControlLineRadioBtn(Line modele, JLabel x1, JTextField x1Value, JLabel y1, JTextField y1Value, JLabel x2,
			JTextField x2Value, JLabel y2, JTextField y2Value, GUI gui) {
		super();
		this.modele = modele;
		this.x1 = x1;
		this.x1Value = x1Value;
		this.y1 = y1;
		this.y1Value = y1Value;
		this.x2 = x2;
		this.x2Value = x2Value;
		this.y2 = y2;
		this.y2Value = y2Value;
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.gui.hideComponents();
		
		this.x1.setVisible(true);
		this.x1Value.setVisible(true);
		this.y1.setVisible(true);
		this.y1Value.setVisible(true);
		this.x2.setVisible(true);
		this.x2Value.setVisible(true);
		this.y2.setVisible(true);
		this.y2Value.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.x1Value.getText()!=null){
			this.modele.setX1(Integer.parseInt(x1Value.getText().trim()));
		}
		if(this.y1Value.getText()!=null){
			this.modele.setY1(Integer.parseInt(y1Value.getText().trim()));
		}
		if(this.x2Value.getText()!=null){
			this.modele.setX2(Integer.parseInt(x2Value.getText().trim()));
		}
		if(this.y2Value.getText()!=null){
			this.modele.setY2(Integer.parseInt(y2Value.getText().trim()));
		}
		
	}

}
