package model;

import java.awt.Color;

public class ColorSVG extends Color {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColorSVG(int rgb) {
		super(rgb);
	}
	
	public String toString(){
		return "rgb("+this.getRed()+","+this.getGreen()+","+this.getBlue()+")";
	}

}
