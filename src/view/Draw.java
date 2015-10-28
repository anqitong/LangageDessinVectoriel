package view;

import java.awt.Color;
import java.util.ArrayList;

import model.ColorSVG;
import model.Drawing;
import model.Path;
import model.Pencil;
import model.specific_path.Circle;
import model.specific_path.Rectangle;

public class Draw {

	public static void main(String[] args) {
		ArrayList<Path> shapes = new ArrayList<Path>();
		Circle c = new Circle(50,40,30);
		Rectangle r = new Rectangle(55,45,50,50);
		r.setColor(new ColorSVG(Color.green.getRGB()));
		Pencil p = new Pencil(4, new ColorSVG(Color.black.getRGB()));
		c.setColor(new ColorSVG(Color.blue.getRGB()));
		shapes.add(new Path(p,c));
		shapes.add(new Path(p,r));
		Drawing d = new Drawing(shapes, 300,200);
		System.out.println(d.getXML());
		
	}
	
}
