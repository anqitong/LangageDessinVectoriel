package model.presentation.xml;

import model.Shape;
import model.specific_path.Polygone;
import model.presentation.PencilState;
import model.presentation.ShapeState;

import java.awt.*;

public class PolygoneXML implements ShapeState {

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
