package model.specific_path;

import model.Pencil;
import model.ShapesType;

public class Line extends ShapesType {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private int x1; // Where is the first point of the line (x axis)
	private int y1; // Where is the first point of the line (y axis)
	private int x2; // Where is the last point of the line (x axis)
	private int y2; // Where is the last point of the line (y axis)
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Line() {
		this.x1 = 0;
		this.y1 = 0;
		this.x2 = 5;
		this.y2 = 0;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getXML(Pencil pencil) {
		return "<line x1=\""+this.getX1()+"\" y1=\""+this.getY1()+"\" x2=\""+this.getX2()+"\" y2=\""+this.getY2()+"\" "+pencil.getXML()+" />";
	}

}
