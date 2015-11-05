package model.specific_path;

import java.awt.Point;



public class PathPart {
	
	private Point point;
	private Point point2;
	private LineType type;
	
	public PathPart(Point point, LineType type) {
		this.point = point;
		this.type = type;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public LineType getType() {
		return type;
	}

	public void setType(LineType type) {
		this.type = type;
	}
}

