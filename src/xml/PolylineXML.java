package xml;

import java.awt.Point;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Polyline;

public class PolylineXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Polyline polyline;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PolylineXML(Polyline polyline) {
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
	public String getDrawing(PencilState pencil) {
		String xml = "";
		for(Point point:this.getPolyline().getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polyline points=\""+xml+"\" "+pencil.getDrawing()+" />";
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
