package model.presentation.xml;

import model.Canvas;
import model.Shape;
import model.specific_path.*;
import model.presentation.Presentation;
import model.presentation.ShapeState;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SVGFile implements Presentation{

	private String fileName;
	private String xmlcontent;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Canvas canvas;

	public static File file;
	private static BufferedWriter out;
	
	/*
	 * the path to the folder where svg files should be saved
	 */
	private static String filepath = "files" + File.separator + "%s.svg";

	
	public SVGFile(String fileName, String xmlcontent, Canvas canvas) {
		this.fileName = fileName;
		this.xmlcontent = xmlcontent;
		this.canvas = canvas;
	}

	public SVGFile(String fileName, String xmlcontent) {
		this(fileName, xmlcontent, new Canvas(1024, 1024));
	}

	public SVGFile(String fileName) {
		this(fileName, "", new Canvas(1024, 1024));
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getXmlcontent() {
		return xmlcontent;
	}

	public void setXmlcontent(String xmlcontent) {
		this.xmlcontent = xmlcontent;
	}

	
	public Canvas getCanvas() {
		return canvas;
	}

	/*
	 * save SVG file into files
	 */
	public boolean writeSVGFile() {
		
		/*
		 * put the file name into the filepath
		 * e.g. "files\filename.svg"
		 */
		file = new File(String.format(filepath, this.getFileName()));
		
		//if the file exists, return false and a warning
		if(file.exists()){
			System.out.println("WARNING : the file "+this.getFileName()+" already exists!");
			return false;
		}else{
			try {
				//write the file and its content
				out = new BufferedWriter(new FileWriter(file));
				out.write(this.getXmlcontent()+"\n");
				out.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} 
		}
	}

	@Override
	public void addShapes(List<Shape> shapes) {
		if (shapes != null)
			this.shapes.addAll(shapes);
	}

	@Override
	public void display() {
		this.xmlcontent = "";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		xml += "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\""
				+ this.canvas.getHeight()
				+ "\" width=\""
				+ this.canvas.getWidth()+"\">";
		this.xmlcontent += xml;

		for (Shape shape : shapes) {
			xml = (String) this.getShapeState(shape).getDrawing(new PencilXML(shape.getPencil()));
			this.xmlcontent +="\n\t"+ xml;
		}

		this.xmlcontent += "\n</svg>";
	}

	@Override
	public ShapeState getShapeState(Shape shape) {
		ShapeState state = null;

		switch (shape.getName()) {
			case Circle:
				state = new CircleXML((Circle)shape);
				break;
			case Ellipse:
				state = new EllipseXML((Ellipse)shape);
				break;
			case Line:
				state = new LineXML((Line)shape);
				break;
			case Path:
				state = new PathXML((Path)shape);
				break;
			case Polygone:
				state = new PolygoneXML((Polygone)shape);
				break;
			case Polyline:
				state = new PolylineXML((Polyline)shape);
				break;
			case Rectangle:
				state = new RectangleXML((Rectangle)shape);
				break;
			case Text:
				state = new TextXML((Text)shape);
				break;
			default:
		}
		return state;
	}

	@Override
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
