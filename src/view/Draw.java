package view;

import language.BasicPainter;
import model.presentation.awt.AWTFrame;
import model.presentation.xml.SVGFile;

public class Draw {

	public static void main(String[] args) {
		BasicPainter painter = new BasicPainter();
		Painting painting = new Painting();
		painting.draw(painter);

		AWTFrame awt = new AWTFrame(painter.getName(), painter.getCanvas());
		awt.addShapes(painter.getShapes());
		awt.createDrawing();

		SVGFile svg = new SVGFile(painter.getName());
		svg.setCanvas(painter.getCanvas());
		svg.addShapes(painter.getShapes());
		svg.createDrawing();
		svg.writeSVGFile();
		svg.view();
	}
	
}
