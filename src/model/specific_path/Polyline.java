package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;

import model.Pencil;
import model.ShapesType;

public class Polyline extends ShapesType {
	
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
	@Override
	public String getXML(Pencil pencil) {
		String xml = "";
		for(Point point:this.getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polyline points=\""+xml+"\" "+pencil.getXML()+" />";
	}


}
