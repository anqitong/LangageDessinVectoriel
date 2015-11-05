package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Shape;
import model.ShapeName;

public class Path extends Shape {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Point start;
	private ArrayList<PathPart> parts;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Path(Point start, ArrayList<PathPart> parts) {
		this.start = start;
		this.parts = parts;
	}
	
	public Path(){
		this.start = new Point(0,0);
		this.parts = new ArrayList<PathPart>();
	}
	
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public ArrayList<PathPart> getParts() {
		return parts;
	}

	public void setParts(ArrayList<PathPart> parts) {
		this.parts = parts;
	}
	
	/************************************
	 *	Methods
	 ************************************/	
	@Override
	public ShapeName getName() {
		return ShapeName.Path;
	}
	
	//@Override
	public boolean isFillable() {
		return this.getStart().equals(this.getParts().get(this.getParts().size()-1).getPoint());
	}
	
}
