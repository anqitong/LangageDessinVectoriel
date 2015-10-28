package xml;

import view.PencilState;
import model.specific_path.Line;

public class LineXML extends ShapeXML {
	
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

}
