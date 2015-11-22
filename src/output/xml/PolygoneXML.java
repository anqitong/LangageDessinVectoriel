package output.xml;

import model.Shape;
import model.specific_path.Polygone;

import java.awt.*;

import output.ShapeState;

public class PolygoneXML implements ShapeState {

	/************************************
	 *	Attributes
	 ************************************/	
	private Polygone polygone;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PolygoneXML(Polygone polygone, StateDelegate delegate) {
		this.delegate = delegate;
		this.polygone = polygone;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Polygone getPolygone() {
		return polygone;
	}

	public void setPoints(Polygone polygone) {
		this.polygone = polygone;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String color = "none";
		if(this.getPolygone().getColor()!=null){
			color = this.getPolygone().getColor().toString();
		}
		
		String xml = "";
		for(Point point:this.getPolygone().getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polygon points=\""+xml+"\" fill=\""+color+"\" "+this.delegate.getPencilXML(this.polygone.getPencil())+" />";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Polygone){
			this.polygone = (Polygone) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}


}
