package model.specific_path;

import model.Pencil;
import model.ShapesType;

public class Circle extends ShapesType {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private int center_x; // Where the center of the circle is (x axis)
	private int center_y; // Where the center of the circle is (y axis)
	private int radius;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Circle(int center_x, int center_y, int radius) {
		this.center_x = center_x;
		this.center_y = center_y;
		this.radius = radius;
	}
	
	public Circle() {
		this.center_x = 0;
		this.center_y = 0;
		this.radius = 1;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	

	public int getCenter_x() {
		return center_x;
	}

	public void setCenter_x(int center_x) {
		this.center_x = center_x;
	}

	public int getCenter_y() {
		return center_y;
	}

	public void setCenter_y(int center_y) {
		this.center_y = center_y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getXML(Pencil pencil) {
		return "<circle cx=\""+this.getCenter_x()+"\" cy=\""+this.getCenter_y()+"\" r=\""+this.getRadius()+"\" "+pencil.getXML()+" />";
	}

}
