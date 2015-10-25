package model;

import java.awt.Color;

/**
 * This is the type: "Crayon"
 */
public class Pencil {

	private int width;
	private Color color;
	
	public Pencil(int width, Color color) {
		super();
		this.width = width;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
