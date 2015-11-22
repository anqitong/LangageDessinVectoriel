package model.specific_path;

import model.Shape;
import model.ShapeName;

public class Rectangle extends Shape {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private int x; // Where the rectangle starts (x axis)
	private int y; // Where the rectangle starts (y axis from top)
	private int height; // The height of the rectangle
	private int width; // The width of the rectangle
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Rectangle(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(){
		this.x = 0;
		this.y = 0;
		this.height = 1;
		this.width = 1;
	}

	/************************************
	 *	Getters and Setters
	 ************************************/	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.setChanged();
		this.notifyObservers();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		this.setChanged();
		this.notifyObservers();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		this.setChanged();
		this.notifyObservers();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public ShapeName getName() {
		return ShapeName.Rectangle;
	}

	/************************************
	 *	Methods
	 ************************************/
	
	@Override
	public boolean isFillable() {
		return true;
	}
}
