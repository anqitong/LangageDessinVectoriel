package model;

import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import model.specific_path.Polygone;
import model.specific_path.Polyline;
import model.specific_path.Rectangle;
import model.specific_path.Path;


public abstract class ShapesType implements ShapesProperties {
	
	/************************************
	 * 	Attributes
	 ************************************/
	private ColorSVG color;
	
	/************************************
	 *	Constructors
	 ************************************/
	
	/**
	 * This static function works as a Fabric and create new sub-ShapesType with the right given name
	 * 
	 * @param name
	 * @return new sub-shapesType
	 * @throws Exception
	 */
	public static ShapesType create(ShapesName name) throws Exception {
		switch(name){
			case Rectangle:
				return new Rectangle();
			
			case Circle:
				return new Circle();
				
			case Ellipse:
				return new Ellipse();
				
			case Polygone:
				return new Polygone();
				
			case Line:
				return new Line();
				
			case Polyline:
				return new Polyline();
				
			case Path:
				return new Path();
				
			default:
				throw new Exception();		
		}
	}
	
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
