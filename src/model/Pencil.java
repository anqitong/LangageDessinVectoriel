package model;

import java.util.Observable;

/**
 * This is the type: "Crayon"
 */
public class Pencil extends Observable{

	private int width;
	private ColorRBG color;
	
	public Pencil(int width, ColorRBG color) {
		super();
		this.width = width;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.notifyObservers();
	}

	public ColorRBG getColor() {
		return color;
	}

	public void setColor(ColorRBG color) {
		this.color = color;
		this.notifyObservers();
	}
	
	public String getXML(){
		return "stroke=\""+this.getColor()+"\" stroke-width=\""+this.getWidth()+"\"";
	}

}
