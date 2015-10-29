package view;

import java.awt.Color;
import java.util.ArrayList;

import xml.CircleXML;
import xml.DrawingXML;
import xml.PencilXML;
import xml.RectangleXML;
import model.ColorSVG;
import model.Drawing;
import model.Pencil;
import model.specific_path.Circle;
import model.specific_path.Rectangle;

public class Draw {

	public static void main(String[] args) {
		ArrayList<Path> shapes = new ArrayList<Path>();
		Circle c = new Circle(50,40,30);
		CircleXML cx= new CircleXML(c); 
		Rectangle r = new Rectangle(55,45,50,50);
		RectangleXML rx = new RectangleXML(r);
		r.setColor(new ColorSVG(Color.green.getRGB()));
		Pencil p = new Pencil(4, new ColorSVG(Color.black.getRGB()));
		PencilXML px = new PencilXML(p);
		c.setColor(new ColorSVG(Color.blue.getRGB()));
		shapes.add(new Path(px,cx));
		shapes.add(new Path(px,rx));
		Drawing d = new Drawing(shapes, 300,200);
		DrawingXML dx = new DrawingXML(d);
		System.out.println(dx.getDrawing());
		
	}
	
}
