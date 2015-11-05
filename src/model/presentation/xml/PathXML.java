package model.presentation.xml;

import model.Shape;
import model.specific_path.LineType;
import model.specific_path.Path;
import model.specific_path.PathPart;
import model.presentation.PencilState;
import model.presentation.ShapeState;

public class PathXML implements ShapeState {
	
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

	public void setPath(Path path) {
		this.path = path;
	}

	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing(PencilState pencil) {
		String xml = "M "+this.getPath().getStart().x+" "+this.getPath().getStart().y;
		for(PathPart pathpart:this.getPath().getParts()){
			try {
				xml = xml+" "+this.getLineTypeLetter(pathpart.getType());
				if(pathpart.getPoint2()!=null){
					xml = xml+" "+pathpart.getPoint2().x+" "+pathpart.getPoint2().y;
				}
			} catch (Exception e) {
				System.out.println("The type: "+pathpart.getType()+"of line used in the Path is not recognised");
				e.printStackTrace();
			}
			xml = xml+" "+pathpart.getPoint().x+" "+pathpart.getPoint().y;
		}
		if(this.getPath().isFillable()){
			xml = "<path d=\""+xml+" Z\" fill=\""+this.getPath().getColor()+"\"";
		}
		else{
			xml = "<path d=\""+xml+"\" fill=\"none\"";
		}
		xml = xml +" "+pencil.getDrawing()+" />";
		return xml;
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
	
	private String getLineTypeLetter(LineType lt) throws Exception {
		switch(lt){
			case Line:
				return "L";
			case Bezier:
				return "Q";
			default:
				throw new Exception();
		}
	}

}
