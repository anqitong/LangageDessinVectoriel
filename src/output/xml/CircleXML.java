package output.xml;

import output.ShapeState;
import model.Shape;
import model.specific_path.Circle;

public class CircleXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Circle circle; // Shape used
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public CircleXML(Circle circle, StateDelegate delegate) {
		this.delegate = delegate;
		this.circle = circle;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}


	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String color = "none";
		if(this.getCircle().getColor()!=null){
			color = this.getCircle().getColor().toString();
		}
		return "<circle cx=\""+this.getCircle().getCenter_x()+"\" cy=\""+this.getCircle().getCenter_y()+"\" r=\""+this.getCircle().getRadius()+"\" fill=\""+color+"\" "+this.delegate.getPencilXML(this.circle.getPencil())+" />";
	}

	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Circle){
			this.circle = (Circle) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}

}
