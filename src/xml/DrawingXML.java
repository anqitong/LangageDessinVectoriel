package xml;

import view.Path;
import model.Drawing;

public class DrawingXML {
	
	/************************************
	 *	Attributes
	 ************************************/
	private Drawing img;
	
	/************************************
	 *	Constructor
	 ************************************/
	public DrawingXML(Drawing img) {
		this.img = img;
	}
	
	/************************************
	 *	Getters and Setters
	 ************************************/
	public Drawing getImg() {
		return img;
	}

	public void setImg(Drawing img) {
		this.img = img;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	public String getDrawing(){
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
		xml=xml+"<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\""+this.getImg().getHeight()+"\" width=\""+this.getImg().getWidth()+"\">";
		for(Path shape: this.getImg().getShapes()){
			xml = xml+"\n\t"+shape.getDrawing();
		}
		xml = xml + "\n</svg>";
		return xml;
	}
	
}
