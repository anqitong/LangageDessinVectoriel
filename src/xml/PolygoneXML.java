package xml;

import java.awt.Point;

import view.PencilState;
import model.specific_path.Polygone;

public class PolygoneXML extends ShapeXML {

	/************************************
	 *	Attributes
	 ************************************/	
	private Polygone polygone;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PolygoneXML(Polygone polygone) {
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
	public String getDrawing(PencilState pencil) {
		String xml = "";
		for(Point point:this.getPolygone().getPoints()){
			xml = xml+" "+point.x+","+point.y;
		}
		return "<polygon points=\""+xml+"\" fill=\""+this.getPolygone().getColor()+"\" "+pencil.getDrawing()+" />";
	}


}
