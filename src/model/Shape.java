package model;


public abstract class Shape implements ShapesProperties {
	
	/************************************
	 * 	Attributes
	 ************************************/
	private ColorRBG color;
	private Pencil pencil;
	
	/************************************
	 *	Constructors
	 ************************************/
	
	
	/************************************
	 *	Methods
	 ************************************/
	
	public ColorRBG getColor(){
		return (this.color!=null) ? this.color : null;
	}
	
	public void setColor(ColorRBG color){
		this.color = color;
	}

	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}

	public Pencil getPencil() {
		return this.pencil;
	}

}
