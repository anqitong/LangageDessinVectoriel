package model.presentation.xml;

import model.Shape;
import model.specific_path.Polyline;
import model.presentation.ShapeState;

import java.awt.*;

public class PolylineXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Polyline polyline;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PolylineXML(Polyline polyline, StateDelegate delegate) {
		this.delegate = delegate;
		this.polyline = polyline;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Polyline getPolyline() {
		return polyline;
	}

	public void setPoints(Polyline polyline) {
		this.polyline = polyline;
	}
	
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String xml = "";
		for(Point point:this.getPolyline().getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polyline points=\""+xml+"\" fill=\"none\" "+this.delegate.getPencilXML(this.polyline.getPencil())+" />";
	}

	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Polyline){
			this.polyline = (Polyline) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}

}
