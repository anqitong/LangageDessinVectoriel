package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Shape;
import model.ShapeName;

public class Polygon extends Shape {

	/************************************
	 *	Attributes
	 ************************************/	
	private ArrayList<Point> points;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Polygon(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Polygon(){
		ArrayList<Point> line = new ArrayList<Point>();
		line.add(new Point(0,0));
		line.add(new Point(0,5));
		line.add(new Point(5,0));
		this.points = line;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	@Override
	public ShapeName getName() {
		return ShapeName.Polygon;
	}

	/************************************
	 *	Methods
	 ************************************/
	@Override
	public boolean isFillable() {
		return true;
	}

}
