package xml;

import java.awt.Point;

import view.PencilState;
import model.specific_path.Polyline;

public class PolylineXML extends ShapeXML {
	
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


}
