package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Pencil;
import model.Shape;

public class Polyline extends Shape {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private ArrayList<Point> points;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Polyline(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Polyline(){
		ArrayList<Point> line = new ArrayList<Point>();
		line.add(new Point(0,0));
		line.add(new Point(0,5));
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
	
	/************************************
	 *	Methods
	 ************************************/


}
