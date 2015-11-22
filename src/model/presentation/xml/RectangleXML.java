package model.presentation.xml;

import model.Shape;
import model.specific_path.Rectangle;
import model.presentation.ShapeState;

public class RectangleXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Rectangle rectangle;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public RectangleXML(Rectangle rectangle, StateDelegate delegate) {
		this.delegate = delegate;
		this.rectangle = rectangle;	
	}

	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setX(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String color = "none";
		if(this.getRectangle().getColor()!=null){
			color = this.getRectangle().getColor().toString();
		}
		return "<rect x=\""+this.getRectangle().getX()+"\" y=\""+this.getRectangle().getY()+"\" width=\""+this.getRectangle().getWidth()+"\" height=\""+this.getRectangle().getHeight()+"\" fill=\""+color+"\" "+this.delegate.getPencilXML(this.rectangle.getPencil())+" />";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Rectangle){
			this.rectangle = (Rectangle) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}
}
