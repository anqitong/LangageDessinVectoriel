package controller.guiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Canvas;
import model.Shape;
import output.awt.AWTFrame;

public class ControlRunGUI implements ActionListener{

	private AWTFrame awt;
	private ArrayList<Shape> shapeList;

	public ControlRunGUI(ArrayList<Shape> shapeList) {
		this.shapeList = shapeList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Create an awt presentation to draw
		awt = new AWTFrame("new awt", new Canvas(600, 600));
		awt.addShapes(shapeList);
		awt.createDrawing();
	}

}
