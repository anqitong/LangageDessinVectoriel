package xml;

import model.Pencil;
import view.PencilState;

public class PencilXML implements PencilState{
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Pencil pencil;
	
	/************************************
	 *	Constructors
	 ************************************/	
	public PencilXML(Pencil pencil) {
		this.pencil = pencil;
	}

	/************************************
	 *	Getters and Setters
	 ************************************/	
	public Pencil getPencil() {
		return pencil;
	}

	public void setPencil(Pencil pencil) {
		this.pencil = pencil;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	@Override
	public String getDrawing() {
		return "stroke=\""+this.getPencil().getColor()+"\" stroke-width=\""+this.getPencil().getWidth()+"\"";
	}

}
