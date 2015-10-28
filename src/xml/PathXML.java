package xml;

import view.PencilState;
import model.specific_path.Path;

public class PathXML extends ShapeXML {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Path path;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PathXML(Path path) {
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
	public String getDrawing(PencilState pencil) {
		// TODO Auto-generated method stub
		return null;
	}

}
