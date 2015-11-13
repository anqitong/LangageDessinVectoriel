package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Shape;
import model.ShapeName;

public class Path extends Shape {

	/************************************
	 *	Attributes
	 ************************************/	
	private ArrayList<Point> points;
	
	/************************************
	 *	Constructors
	 ************************************/	

	@Override
	public ShapeName getName() {
		return ShapeName.Path;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public boolean isFillable() {
		return false;
	}
}
