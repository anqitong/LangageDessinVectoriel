package model;

import java.awt.Color;

/**
 * 
 * Figures taken from http://www.w3schools.com/svg/ for SVG files
 * Rectangle, Circle, Ellipse, Line, Polyline, Polygone, Path
 *
 */
public interface ShapesProperties {

	public void setColor(ColorSVG color);
	public Color getColor();
	
	/**
	 * This function return the XML specific for each shapes (xml used inside svg tags)
	 * @param pencil
	 * @return String (XML)
	 */
	public String getXML(Pencil pencil);
	
	
}
