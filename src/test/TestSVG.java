package test;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import model.ColorSVG;
import model.Pencil;
import model.Shape;
import model.presentation.xml.SVGFile;
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
	}
	
	/*
	 * Test the insert method
	 */
	@Test
	public void insert(){
		
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

		//Create the first svg
		SVGFile svg = new SVGFile("test");
		svg.addShapes(shapes);
		svg.display();
		
		Rectangle r2 = new Rectangle(60, 60, 60, 60);
		r2.setPencil(p);
		ArrayList<Shape> shape2 = new ArrayList<Shape>();
		shape2.add(r2);
		
		//Create the second svg
		SVGFile svg2 = new SVGFile("insert");
		svg2.addShapes(shape2);
		svg2.display();
		

		svg.insert(svg2);
		svg.display();
		System.out.println(svg.getXmlcontent());
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml+="\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">";
		xml+="\n\t<circle cx=\"50\" cy=\"40\" r=\"30\" fill=\"rgb(0,0,255)\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		xml+="\n\t<rect x=\"55\" y=\"45\" width=\"50\" height=\"50\" fill=\"rgb(0,255,0)\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		// TODO see to change indent
		xml+="\n\t<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml+="\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"1024\" width=\"1024\">";
		// TODO see to change null into None
		xml+="\n\t<rect x=\"60\" y=\"60\" width=\"60\" height=\"60\" fill=\"null\" stroke=\"rgb(0,0,0)\" stroke-width=\"4\" />";
		xml+="\n</svg>";
		xml+="\n</svg>";
		
		Assert.assertEquals(xml, svg.getXmlcontent());

	}

}
