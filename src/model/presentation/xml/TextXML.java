package model.presentation.xml;

import model.Shape;
import model.specific_path.Text;
import model.presentation.ShapeState;

public class TextXML implements ShapeState {

	/************************************
	 *	Attributes
	 ************************************/	
	private Text text;
	private StateDelegate delegate;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public TextXML(Text text, StateDelegate delegate) {
		this.delegate = delegate;
		this.text = text;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		return "<text x=\""+this.getText().getX()+"\" y=\""+this.getText().getY()+"\" "+this.delegate.getPencilXML(this.text.getPencil())+"\">"+this.getText().getText()+"</text>";
	}
	
	@Override
	public void setShape(Shape shape) throws Exception {
		if(shape instanceof Text){
			this.text = (Text) shape;
		}
		else{
			throw new Exception("The shape is not of the right type");
		}
		
	}


}
