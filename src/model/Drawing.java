package model;

import java.util.ArrayList;

public class Drawing {
	
	/************************************
	 *	Attributes
	 ************************************/
	private ArrayList<Path> shapes;
	private int height;
	private int width;
	
	/************************************
	 *	Constructor
	 ************************************/
	public Drawing(ArrayList<Path> shapes, int height, int width) {
		this.shapes = shapes;
		this.height = height;
		this.width = width;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/
	public ArrayList<Path> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Path> shapes) {
		this.shapes = shapes;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/************************************
	 *	Methods
	 ************************************/
	public String getXML(){
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		xml=xml+"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\""+this.getHeight()+"\" width=\""+this.getWidth()+"\">";
		for(Path shape: this.getShapes()){
			xml = xml+"\n\t"+shape.getXML();
		}
		xml = xml + "\n</svg>";
		return xml;
	}
	
}
