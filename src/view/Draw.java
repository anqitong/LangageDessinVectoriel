package view;

import java.awt.Color;
import java.util.ArrayList;

import model.*;
import model.specific_path.Circle;
import model.specific_path.Rectangle;

public class Draw {

	public static void main(String[] args) {
		Pencil p = new Pencil(4, new ColorSVG(Color.black.getRGB()));
		Circle c = new Circle(50,40,30);
		c.setColor(new ColorSVG(Color.blue.getRGB()));
		c.setPencil(p);
		Rectangle r = new Rectangle(55,45,50,50);
		r.setPencil(p);
		r.setColor(new ColorSVG(Color.green.getRGB()));

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(c);
		shapes.add(r);

		SVGFile svg = new SVGFile("test.svg");
		svg.addShapes(shapes);
		svg.display();
		System.out.println(svg.getXmlcontent());

	}
	
}
