package model;

import java.util.Observable;

public abstract class Shape extends Observable implements ShapesProperties {
	
	/************************************
	 * 	Attributes
	 ************************************/
	private ColorSVG color;
	private Pencil pencil;
	
	/************************************
	 *	Constructors
	 ************************************/
	
	
	/************************************
	 *	Methods
	 ************************************/
	
	public ColorSVG getColor(){
		return (this.color!=null) ? this.color : null;
	}
	
	public void setColor(ColorSVG color){
		this.color = color;
	}

	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}

	public Pencil getPencil() {
		return this.pencil;
	}

}
