package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;



public class PathPart {
	
	private ArrayList<Point> points;
	private LineType type;
	
	public PathPart(Point point, LineType type) {
		this.points = new ArrayList<Point>();
		this.points.add(point);
		this.type = type;
	}

	public PathPart(ArrayList<Point> points, LineType type) {
		super();
		this.points = points;
		this.type = type;
	}


	public ArrayList<Point> getPoints() {
		return points;
	}


	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}

	public LineType getType() {
		return type;
	}

	public void setType(LineType type) {
		this.type = type;
	}
}

