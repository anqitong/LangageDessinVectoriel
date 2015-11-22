package model.specific_path;

import java.awt.Point;
import java.util.ArrayList;



public class PathPart {
	
	/************************************
	 *	Attributes
	 ************************************/
	private ArrayList<Point> points = new ArrayList<Point>();;
	private LineType type;
	
	/************************************
	 *	Constructors
	 ************************************/
	public PathPart(Point point, LineType type) {
		this.points.add(point);
		this.type = type;
		try {
			this.checkPoints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PathPart(ArrayList<Point> points, LineType type) {
		super();
		this.points = points;
		this.type = type;
		try {
			this.checkPoints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PathPart(LineType type, Point... points) {
		super();
		for(Point p: points){
			this.points.add(p);
		}
		this.type = type;
		try {
			this.checkPoints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/************************************
	 *	Setters and Getters
	 ************************************/
	public ArrayList<Point> getPoints() {
		return points;
	}


	public void setPoints(ArrayList<Point> points) {
		this.points = points;
		try {
			this.checkPoints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LineType getType() {
		return type;
	}

	public void setType(LineType type) {
		this.type = type;
		try {
			this.checkPoints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/************************************
	 *	Methods
	 ************************************/
	
	/**
	 * This method check if the argument in the PathPart are correct.
	 * @throws Exception
	 */
	private void checkPoints() throws Exception {
		boolean pass = false;
		
		// Here, we check for the points in the parts except the first one that is either defined in the 
		//first argument of the Path or is the last point of the previous PathPart.
		switch(this.type){
			case Line:
				// A line should only have one point as in Path, the first point is already set
				pass = (this.getPoints().size() == 1);break;
			case QuadricBezier:
				// The first point is for the slope of the curve and the last for where the curve finishes
				pass = (this.getPoints().size() == 2);break;
			case SmoothBezier:
				// The point is for where the curve finish. The slope is assumed to be the same as previousely
				// So the SmoothBezier require a Quadric or Smooth Bezier curve before (or it will draw a line).
				pass = (this.getPoints().size() == 1);break;
			case Curveto:
				// The first point is for the slope of the curve at the beginning, 
				// the second for the slope of the curve at the end and the last for where the curve finishes
				pass = (this.getPoints().size() == 3);break;
			case SmoothCurveto:
				// The first point is the slope at the end. The slope at the beginning is the same as the previous one
				// See SmoothBezier for that. The last point is where the curve ends
				// So the SmoothCurveto require a Curveto or SmoothCurveto curve before (or it will draw a line).
				pass = (this.getPoints().size() == 2);break;
			case Arc:
				// They can be done with ellipse and parts hidden or Curveto.
				// As they don't take the same kind of parameters, we will not use them here.
				break;
			default:
				throw new Exception();
		}
		if(!pass){
			throw new Exception();
		}
	}
}

