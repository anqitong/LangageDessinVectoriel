package output.xml;

import model.Shape;
import model.specific_path.Polygon;

import java.awt.*;

import output.ShapeState;

public class PolygonXML implements ShapeState {

	/************************************
	 *	Attributes
	 ************************************/	
	private Polygon polygon;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PolygonXML(Polygon polygon, StateDelegate delegate) {
		this.delegate = delegate;
		this.polygon = polygon;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Polygon getPolygon() {
		return polygon;
	}

	public void setPoints(Polygon polygon) {
		this.polygon = polygon;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String color = "none";
		if(this.getPolygon().getColor()!=null){
			color = this.getPolygon().getColor().toString();
		}
		
		String xml = "";
		for(Point point:this.getPolygon().getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polygon points=\""+xml+"\" fill=\""+color+"\" "+this.delegate.getPencilXML(this.polygon.getPencil())+" />";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Polygon){
			this.polygon = (Polygon) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}


}
