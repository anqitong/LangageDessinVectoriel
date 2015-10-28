package model.specific_path;

import model.Pencil;
import model.Shape;

public class Ellipse extends Shape {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private int center_x; // Where the center of the ellipse is (x axis)
	private int center_y; // Where the center of the ellipse is (y axis)
	private int radius_x; // The length between the center and the point on the left (or right)
	private int radius_y; // The length between the center and the point on the top
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Ellipse(int center_x, int center_y, int radius_x, int radius_y) {
		this.center_x = center_x;
		this.center_y = center_y;
		this.radius_x = radius_x;
		this.radius_y = radius_y;
	}
	
	public Ellipse() {
		this.center_x = 0;
		this.center_y = 0;
		this.radius_x = 2;
		this.radius_y = 1;
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

	public int getRadius_x() {
		return radius_x;
	}

	public void setRadius_x(int radius_x) {
		this.radius_x = radius_x;
	}
	
	public int getRadius_y() {
		return radius_y;
	}

	public void setRadius_y(int radius_y) {
		this.radius_y = radius_y;
	}

	/************************************
	 *	Methods
	 ************************************/

}
