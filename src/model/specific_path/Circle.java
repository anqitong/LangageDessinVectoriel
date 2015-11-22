package model.specific_path;

import model.Shape;
import model.ShapeName;

public class Circle extends Shape {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private int center_x; // Where the center of the circle is (x axis)
	private int center_y; // Where the center of the circle is (y axis)
	private int radius; // The radius of the circle
	
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
		this.setChanged();
		this.notifyObservers();
	}

	public int getCenter_y() {
		return center_y;
	}

	public void setCenter_y(int center_y) {
		this.center_y = center_y;
		this.setChanged();
		this.notifyObservers();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public ShapeName getName() {
		return ShapeName.Circle;
	}

	/************************************
	 *	Methods
	 ************************************/
	@Override
	public boolean isFillable() {
		return true;
	}
}
