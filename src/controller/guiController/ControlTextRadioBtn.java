package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.specific_path.Text;
import view.GUI;

//controller for the "text" radio button
public class ControlTextRadioBtn implements Observer, ActionListener{

	private Text modele;
	private JLabel textX;
	private JTextField textValueX;
	private JLabel textY;
	private JTextField textValueY;
	private JLabel textValueLabel;
	private JTextField textValue;
	private GUI gui;


	public ControlTextRadioBtn(Text modele, JLabel textX, JTextField textValueX, JLabel textY, JTextField textValueY,
			JLabel textValueLabel, JTextField textValue, GUI gui) {
		this.modele = modele;
		this.textX = textX;
		this.textValueX = textValueX;
		this.textY = textY;
		this.textValueY = textValueY;
		this.textValueLabel = textValueLabel;
		this.textValue = textValue;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//hide the input fields of all the shape elements
		this.gui.hideComponents();

		//set visible the input fields for text
		this.textX.setVisible(true);
		this.textValueX.setVisible(true);
		this.textY.setVisible(true);
		this.textValueY.setVisible(true);
		this.textValueLabel.setVisible(true);
		this.textValue.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
//		if(this.textValueX.getText()!=null){
//			this.modele.setX(Integer.parseInt(this.textValueX.getText().trim()));
//		}
//		if(this.textValueY.getText()!=null){
//			this.modele.setY(Integer.parseInt(this.textValueY.getText().trim()));
//		}
//		if(this.textValue.getText()!=null){
//			this.modele.setText(this.textValue.getText());
//		}
		
	}
}
