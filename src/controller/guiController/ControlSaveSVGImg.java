package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Shape;
import output.xml.SVGFile;


public class ControlSaveSVGImg implements ActionListener{

	private ArrayList<Shape> shapeList;
	private JTextField imgNameInput;

	public ControlSaveSVGImg(ArrayList<Shape> shapeList, JTextField imgNameInput) {
		this.shapeList = shapeList;
		this.imgNameInput = imgNameInput;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.imgNameInput.getText().equals("")){
			//create new SVG file
			SVGFile svg = new SVGFile(this.imgNameInput.getText());
			// Add the shapes to draw
			svg.addShapes(shapeList);
			// Create the drawing in the object
			svg.createDrawing();
			//System.out.println(svg.getXmlcontent());
			// Create a svg file with the drawing
			svg.writeSVGFile();
			// Open it in your defaul browser
			svg.view();
		}else{
			JOptionPane.showMessageDialog(null, "Error : the name input is empty !");
		}
		
		
	}


}


