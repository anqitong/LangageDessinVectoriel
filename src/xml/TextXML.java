package xml;

import view.PencilState;
import model.specific_path.Text;

public class TextXML extends ShapeXML {

	/************************************
	 *	Attributes
	 ************************************/	
	private Text text;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public TextXML(Text text) {
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
	public String getDrawing(PencilState pencil) {
		return "<text x=\""+this.getText().getX()+"\" y=\""+this.getText().getY()+"\" "+pencil.getDrawing()+"\">"+this.getText().getText()+"</text>";
	}


}
