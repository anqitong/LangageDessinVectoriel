package model;

import java.awt.Color;

/**
 * 
 * Figures taken from http://www.w3schools.com/svg/ for SVG files
 * Rectangle, Circle, Ellipse, Line, Polyline, Polygone, Path
 *
 */
public interface ShapesProperties {

	/**
	 * Fill the shape with a color. (ie "Remplir")
	 * @param color
	 */
	public void setColor(ColorRBG color);
	public Color getColor();
	public ShapeName getName();
	public Pencil getPencil();
	
	/**
	 * Return true if the shape can be filled with some color
	 */
	boolean isFillable();
	
}
