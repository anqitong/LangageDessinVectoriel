package model;


public abstract class Shape implements ShapesProperties {
	
	/************************************
	 * 	Attributes
	 ************************************/
	private ColorSVG color;
	
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

}
