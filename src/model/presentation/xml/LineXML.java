package model.presentation.xml;

import model.Shape;
import model.specific_path.Line;
import model.presentation.PencilState;
import model.presentation.ShapeState;

public class LineXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Line line;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public LineXML(Line line) {
		this.line = line;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing(PencilState pencil) {
		return "<line x1=\""+this.getLine().getX1()+"\" y1=\""+this.getLine().getY1()+"\" x2=\""+this.getLine().getX2()+"\" y2=\""+this.getLine().getY2()+"\" "+pencil.getDrawing()+" />";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Line){
			this.line = (Line) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}

}
