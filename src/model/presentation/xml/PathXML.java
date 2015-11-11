package model.presentation.xml;

import model.Shape;
import model.specific_path.Path;
import model.presentation.ShapeState;

public class PathXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Path path;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PathXML(Path path, StateDelegate delegate) {
		this.delegate = delegate;
		this.path = path;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Path getPath() {
		return path;
	}

	public void setLine(Path path) {
		this.path = path;
	}

	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Path){
			this.path = (Path) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}

}
