package view;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import model.*;
import model.specific_path.Circle;
import model.specific_path.LineType;
import model.specific_path.Path;
import model.specific_path.PathPart;
import model.specific_path.Rectangle;
import model.presentation.xml.SVGFile;

public class Draw {

	public static void main(String[] args) {
		
		/************************************
		 *	Circle and Rectangle
		 ************************************/
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

		SVGFile svg = new SVGFile("test");
		svg.addShapes(shapes);
		svg.display();
		System.out.println(svg.getXmlcontent());
		svg.writeSVGFile();
	
		
		
		/************************************
		 *	Closed Path
		 ************************************/
		Path path = new Path();
		path.setStart(new Point(150, 0));
		path.setPencil(p);
		ArrayList<PathPart> parts = new ArrayList<PathPart>();
		parts.add(new PathPart(new Point(75, 200), LineType.Line));
		parts.add(new PathPart(new Point(225, 200), LineType.Line));
		parts.add(new PathPart(new Point(150, 0), LineType.Line));
		path.setParts(parts);
		path.setColor(new ColorSVG(Color.blue.getRGB()));
		ArrayList<Shape> shapes2 = new ArrayList<Shape>();
		shapes2.add(path);
		SVGFile svg2 = new SVGFile("ClosedPath");
		svg2.addShapes(shapes2);
		svg2.display();
		System.out.println(svg2.getXmlcontent());
		svg2.writeSVGFile();
		
		
		/************************************
		 *	Paths with one Bezier Line
		 ************************************/
		Pencil pred = new Pencil(3, new ColorSVG(Color.red.getRGB()));
		Path path2 = new Path();
		path2.setStart(new Point(100, 350));
		path2.setPencil(pred);
		ArrayList<PathPart> parts2 = new ArrayList<PathPart>();
		parts2.add(new PathPart(new Point(250, 50), LineType.Line));
		path2.setParts(parts2);
		
		Path path3 = new Path();
		path3.setStart(new Point(250, 50));
		path3.setPencil(pred);
		ArrayList<PathPart> parts3 = new ArrayList<PathPart>();
		parts3.add(new PathPart(new Point(400, 350), LineType.Line));
		path3.setParts(parts3);
		
		Pencil pgreen = new Pencil(3, new ColorSVG(Color.green.getRGB()));
		Path path4 = new Path();
		path4.setStart(new Point(175, 200));
		path4.setPencil(pgreen);
		ArrayList<PathPart> parts4 = new ArrayList<PathPart>();
		parts4.add(new PathPart(new Point(325, 200), LineType.Line));
		path4.setParts(parts4);
		
		Pencil pblue = new Pencil(3, new ColorSVG(Color.blue.getRGB()));
		Path path5 = new Path();
		path5.setStart(new Point(100, 350));
		path5.setPencil(pblue);
		ArrayList<PathPart> parts5 = new ArrayList<PathPart>();
		PathPart bez = new PathPart(new Point(250, 50), LineType.Bezier);
		bez.getPoints().add(new Point(400, 350));
		parts5.add(bez);
		path5.setParts(parts5);
		
		
		ArrayList<Shape> shapes3 = new ArrayList<Shape>();
		shapes3.add(path2);
		shapes3.add(path3);
		shapes3.add(path4);
		shapes3.add(path5);
		
		SVGFile svg3 = new SVGFile("OpenedPath");
		svg3.addShapes(shapes3);
		svg3.display();
		System.out.println(svg3.getXmlcontent());
		svg3.writeSVGFile();
	}
	
}
