package controller;

import model.Shape;
import model.ShapeName;
import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import model.specific_path.Path;
import model.specific_path.Polygone;
import model.specific_path.Polyline;
import model.specific_path.Rectangle;

public class ShapeFactory {

	/**
	 * This static function works as a Fabric and create new sub-ShapesType with the right given name
	 * 
	 * @param name
	 * @return new sub-shapesType
	 * @throws Exception
	 */
	public static Shape create(ShapeName name) throws Exception {
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
	
}
