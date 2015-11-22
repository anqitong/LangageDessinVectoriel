package output.xml;

import output.ShapeState;
import model.Shape;
import model.specific_path.Ellipse;

public class EllipseXML implements ShapeState {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Ellipse ellipse; // Shape used
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public EllipseXML(Ellipse ellipse, StateDelegate delegate) {
		this.delegate = delegate;
		this.ellipse = ellipse;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	

	public Ellipse getEllipse() {
		return ellipse;
	}

	public void setCircle(Ellipse ellipse) {
		this.ellipse = ellipse;
	}


	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		String color = "none";
		if(this.getEllipse().getColor()!=null){
			color = this.getEllipse().getColor().toString();
		}
		return "<circle cx=\""+this.getEllipse().getCenter_x()+"\" cy=\""+this.getEllipse().getCenter_y()+"\" rx=\""+this.getEllipse().getRadius_x()+"\" ry=\""+this.getEllipse().getRadius_y()+"\" fill=\""+color+"\" "+this.delegate.getPencilXML(this.ellipse.getPencil())+" />";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Ellipse){
			this.ellipse = (Ellipse) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}

}
