package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Shape;

public class Polygone extends Shape {

	/************************************
	 *	Attributes
	 ************************************/	
	private ArrayList<Point> points;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Polygone(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Polygone(){
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
	
	/************************************
	 *	Methods
	 ************************************/


}
