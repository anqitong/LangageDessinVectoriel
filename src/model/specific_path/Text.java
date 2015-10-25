package model.specific_path;

import model.Pencil;
import model.ShapesType;

public class Text extends ShapesType {

	/************************************
	 *	Attributes
	 ************************************/	
	private int x; // Where is the start of the text (x axis)
	private int y; // Where is the start of the text (y axis, from the top)
	private String text; // The actual text that will be displayed
	
	/************************************
	 *	Constructors
	 ************************************/	
	public Text(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
	}
	
	public Text() {
		this.x = 0;
		this.y = 0;
		this.text = "Text";
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getXML(Pencil pencil) {
		return "<text x=\""+this.getX()+"\" y=\""+this.getY()+"\" "+pencil.getXML()+"\">"+this.getText()+"</text>";
	}


}
