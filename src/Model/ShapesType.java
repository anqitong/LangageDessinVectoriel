package Model;

import java.awt.Color;

import SpecificPath.Circle;
import SpecificPath.Ellipse;
import SpecificPath.Line;
import SpecificPath.Path;
import SpecificPath.Polygone;
import SpecificPath.Polyline;
import SpecificPath.Rectangle;

public abstract class ShapesType implements ShapesProperties {
	
	/************************************
	 * 	Attributes
	 ************************************/
	private Color color;
	
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
	
	public Color getColor(){
		return (this.color!=null) ? this.color : null;
	}
}
