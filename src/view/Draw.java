package view;

import model.*;
import model.presentation.xml.SVGFile;
import model.specific_path.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Draw {

	public static void main(String[] args) {
		
		/************************************
		 *	Circle and Rectangle
		 ************************************/
		
		// Create a new black pencil
		Pencil p = new Pencil(4, new ColorRBG(Color.black.getRGB()));
		
		// Create a Cirle with a radius of 30 with the center in (50,40)
		Circle c = new Circle(50,40,30);
		
		// Fill the center of the circle in blue
		c.setColor(new ColorRBG(Color.blue.getRGB()));
		
		// Add the pencil to the Circle
		c.setPencil(p);
		
		// Create a Rectangle
		Rectangle r = new Rectangle(55,45,50,50);
		
		// Set the pencil
		r.setPencil(p);
		
		// Fill it
		r.setColor(new ColorRBG(Color.green.getRGB()));
		
		
		/************************************
		 *	Closed Path
		 ************************************/
		// Create a new Path (will be a triangle)
		Path path = new Path();
		
		// Start to defined the first point
		path.setStart(new Point(150, 0));
		
		// Add the black pencil to it (defined earlier)
		path.setPencil(p);
		ArrayList<PathPart> parts = new ArrayList<PathPart>();
		
		// Add 3 strait lines
		parts.add(new PathPart(new Point(75, 200), LineType.Line));
		parts.add(new PathPart(new Point(225, 200), LineType.Line));
		parts.add(new PathPart(new Point(150, 0), LineType.Line));
		// As the last point is the same as the first one, it will be a closed path
		
		// Add the parts to the Path
		path.setParts(parts);
		
		// Fill the shape with blue
		path.setColor(new ColorRBG(Color.blue.getRGB()));
		ArrayList<Shape> shapes2 = new ArrayList<Shape>();
		shapes2.add(path);
		
		// Create the drawing
		SVGFile svg2 = new SVGFile("ClosedPath");
		
		// Add the shape
		svg2.addShapes(shapes2);
		
		// Update it
		svg2.createDrawing();
		System.out.println(svg2.getXmlcontent());
		
		// Create the file
		svg2.writeSVGFile();
		
		
		/************************************
		 *	Paths with one Bezier Line
		 ************************************/
		
		// Create a red Pencil
		Pencil pred = new Pencil(3, new ColorRBG(Color.red.getRGB()));
		
		// Create a new Path (a red line that goes up)
		Path path2 = new Path();
		path2.setStart(new Point(100, 350));
		path2.setPencil(pred);
		ArrayList<PathPart> parts2 = new ArrayList<PathPart>();
		parts2.add(new PathPart(new Point(250, 50), LineType.Line));
		path2.setParts(parts2);
		
		// Create another red path (line that goes down and linked to the first path)
		Path path3 = new Path();
		path3.setStart(new Point(250, 50));
		path3.setPencil(pred);
		ArrayList<PathPart> parts3 = new ArrayList<PathPart>();
		parts3.add(new PathPart(new Point(400, 350), LineType.Line));
		path3.setParts(parts3);
		
		// Create a Path (horizontal green line)
		Pencil pgreen = new Pencil(3, new ColorRBG(Color.green.getRGB()));
		Path path4 = new Path();
		path4.setStart(new Point(175, 200));
		path4.setPencil(pgreen);
		ArrayList<PathPart> parts4 = new ArrayList<PathPart>();
		parts4.add(new PathPart(new Point(325, 200), LineType.Line));
		path4.setParts(parts4);
		
		// Create a Path (Bezier blue line)
		Pencil pblue = new Pencil(3, new ColorRBG(Color.blue.getRGB()));
		Path path5 = new Path();
		path5.setStart(new Point(100, 350));
		path5.setPencil(pblue);
		ArrayList<PathPart> parts5 = new ArrayList<PathPart>();
		PathPart bez = new PathPart(LineType.QuadricBezier, new Point(250, 50), new Point(400, 350));
		parts5.add(bez);
		path5.setParts(parts5);
		
		// Gather all the paths
		ArrayList<Shape> shapes3 = new ArrayList<Shape>();
		shapes3.add(path2);
		shapes3.add(path3);
		shapes3.add(path4);
		shapes3.add(path5);
		
		// Create a new svg drawing
		SVGFile svg3 = new SVGFile("OpenedPath");
		
		// Add the shapes
		svg3.addShapes(shapes3);
		
		// Update svg3
		svg3.createDrawing();
		System.out.println(svg3.getXmlcontent());
		
		// Create the file
		svg3.writeSVGFile();
	}
	
}
