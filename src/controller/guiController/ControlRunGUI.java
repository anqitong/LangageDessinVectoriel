package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Shape;
import model.presentation.xml.SVGFile;

public class ControlRunGUI implements Observer, ActionListener{

	

	private ArrayList<Shape> shapeList;
	
	public ControlRunGUI(ArrayList<Shape> shapeList) {
		this.shapeList = shapeList;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//create new SVG file
		SVGFile svg = new SVGFile("testGUI");
		// Add the shapes to draw
		svg.addShapes(shapeList);
		// Create the drawing in the object
		svg.createDrawing();
		//System.out.println(svg.getXmlcontent());
		// Create a svg file with the drawing
		svg.writeSVGFile();
		// Open it in your defaul browser
		svg.view();
	}

	@Override
	public void update(Observable o, Object arg) {
	}

}
