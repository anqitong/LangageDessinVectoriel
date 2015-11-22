package test;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import model.ColorRBG;
import model.Pencil;
import model.Shape;
import model.presentation.xml.SVGFile;
import model.specific_path.LineType;
import model.specific_path.Path;
import model.specific_path.PathPart;
import model.specific_path.Circle;
import model.specific_path.Rectangle;

public class TestSVG {

	/*
	 * The creation of the file "svg" return true 
	 */
	@Test
	public void createSVG_success() {
		SVGFile svg = new SVGFile("test","some content");
		Assert.assertEquals(true, svg.writeSVGFile());
		svg.delete();
	}
	
	/*
	 * The creation of the file "f2" return false
	 * because there is already another file with 
	 * the same name 
	 */
	@Test
	public void createSVG_fail(){
		SVGFile f1 = new SVGFile("testFile","some content");
		f1.writeSVGFile();
		SVGFile f2 = new SVGFile("testFile","some content");
		Assert.assertEquals(false, f2.writeSVGFile());
		f1.getFile().delete();
	}
	
	/*
	 * Test the deletion method 
	 */
	@Test
	public void delete_svg() {
		SVGFile svg = new SVGFile("test","some content");
		svg.writeSVGFile();
		Assert.assertTrue(svg.delete());
	}
	
	/************************************
	 *	Paths with one Bezier Line
	 ************************************/
	@Test
	public void create_open_path(){
	Pencil pred = new Pencil(3, new ColorRBG(Color.red.getRGB()));
	
	// Create a red line
	Path path2 = new Path();
	path2.setStart(new Point(100, 350));
	path2.setPencil(pred);
	ArrayList<PathPart> parts2 = new ArrayList<PathPart>();
	parts2.add(new PathPart(new Point(250, 50), LineType.Line));
	path2.setParts(parts2);
	
	// Create another read line that touch the first one
	Path path3 = new Path();
	path3.setStart(new Point(250, 50));
	path3.setPencil(pred);
	ArrayList<PathPart> parts3 = new ArrayList<PathPart>();
	parts3.add(new PathPart(new Point(400, 350), LineType.Line));
	path3.setParts(parts3);
	
	Pencil pgreen = new Pencil(3, new ColorRBG(Color.green.getRGB()));
	// Create a horizontal green line
	Path path4 = new Path();
	path4.setStart(new Point(175, 200));
	path4.setPencil(pgreen);
	ArrayList<PathPart> parts4 = new ArrayList<PathPart>();
	parts4.add(new PathPart(new Point(325, 200), LineType.Line));
	path4.setParts(parts4);
	
	Pencil pblue = new Pencil(3, new ColorRBG(Color.blue.getRGB()));
	// Create a bezier blue line
	Path path5 = new Path();
	path5.setStart(new Point(100, 350));
	path5.setPencil(pblue);
	ArrayList<PathPart> parts5 = new ArrayList<PathPart>();
	PathPart bez = new PathPart(LineType.QuadricBezier, new Point(250, 50), new Point(400, 350));
	parts5.add(bez);
	path5.setParts(parts5);
	
	//Add all the lines together
	ArrayList<Shape> shapes3 = new ArrayList<Shape>();
	shapes3.add(path2);
	shapes3.add(path3);
	shapes3.add(path4);
	shapes3.add(path5);
	
	// Create the drawing
	SVGFile svg3 = new SVGFile("OpenedPath");
	
	// Add the lines to it
	svg3.addShapes(shapes3);
	svg3.createDrawing();
	System.out.println(svg3.getXmlcontent());
	
	// Assert for the right result
	Assert.assertEquals(svg3.getXmlcontent(), "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
			+"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">\n\t"
			+"<path d=\"M 100 350 L 250 50\" fill=\"none\" stroke=\"rgb(255,0,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 250 50 L 400 350\" fill=\"none\" stroke=\"rgb(255,0,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 175 200 L 325 200\" fill=\"none\" stroke=\"rgb(0,255,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 100 350 Q 250 50 400 350\" fill=\"none\" stroke=\"rgb(0,0,255)\" stroke-width=\"3\" />\n"
			+"</svg>");
	}
	
	/*
	 * Test the insert method
	 */
	@Test
	public void insert(){
		
		Pencil p = new Pencil(4, new ColorRBG(Color.black.getRGB()));
		Circle c = new Circle(50,40,30);
		c.setColor(new ColorRBG(Color.blue.getRGB()));
		c.setPencil(p);
		Rectangle r = new Rectangle(55,45,50,50);
		r.setPencil(p);
		r.setColor(new ColorRBG(Color.green.getRGB()));

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(c);
		shapes.add(r);

		//Create the first svg
		SVGFile svg = new SVGFile("test");
		svg.addShapes(shapes);
		svg.createDrawing();
		
		Rectangle r2 = new Rectangle(60, 60, 60, 60);
		r2.setPencil(p);
		ArrayList<Shape> shape2 = new ArrayList<Shape>();
		shape2.add(r2);
		
		//Create the second svg
		SVGFile svg2 = new SVGFile("insert");
		svg2.addShapes(shape2);
		svg2.createDrawing();
		

		svg.insert(svg2);
		svg.createDrawing();
		System.out.println(svg.getXmlcontent());
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml+="\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">";
		xml+="\n\t<circle cx=\"50\" cy=\"40\" r=\"30\" fill=\"rgb(0,0,255)\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		xml+="\n\t<rect x=\"55\" y=\"45\" width=\"50\" height=\"50\" fill=\"rgb(0,255,0)\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		// TODO see to change indent
		xml+="\n\t<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml+="\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">";
		xml+="\n\t<rect x=\"60\" y=\"60\" width=\"60\" height=\"60\" fill=\"none\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		xml+="\n</svg>";
		xml+="\n</svg>";
		
		Assert.assertEquals(xml, svg.getXmlcontent());

	}

}
