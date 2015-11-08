package test;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import model.ColorSVG;
import model.Pencil;
import model.Shape;
import model.presentation.xml.SVGFile;
import model.specific_path.LineType;
import model.specific_path.Path;
import model.specific_path.PathPart;

public class TestSVG {

	/*
	 * The creation of the file "svg" return true 
	 */
	@Test
	public void createSVG_success() {
		SVGFile svg = new SVGFile("test","some content");
		Assert.assertEquals(true, svg.writeSVGFile());
		svg.getFile().delete();
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
	
	/************************************
	 *	Paths with one Bezier Line
	 ************************************/
	@Test
	public void create_open_path(){
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
	PathPart bez = new PathPart(new Point(250, 50), LineType.QuadricBezier);
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
	Assert.assertEquals(svg3.getXmlcontent(), "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
			+"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">\n\t"
			+"<path d=\"M 100 350 L 250 50\" fill=\"none\" stroke=\"rgb(255,0,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 250 50 L 400 350\" fill=\"none\" stroke=\"rgb(255,0,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 175 200 L 325 200\" fill=\"none\" stroke=\"rgb(0,255,0)\" stroke-width=\"3\" />\n\t"
			+"<path d=\"M 100 350 Q 250 50 400 350\" fill=\"none\" stroke=\"rgb(0,0,255)\" stroke-width=\"3\" />\n"
			+"</svg>");
	}

}
