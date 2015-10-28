package model;

/**
 * This is the type: "Chemin"
 */
public class Path {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private Pencil style;
	private ShapesType content;
	
	/************************************
	 *	Constructor
	 ************************************/
	public Path(Pencil style, ShapesType content) {
		super();
		this.style = style;
		this.content = content;
	}

	/************************************
	 *	Getters and Setters
	 ************************************/
	public Pencil getStyle() {
		return style;
	}

	public void setStyle(Pencil style) {
		this.style = style;
	}

	public ShapesType getContent() {
		return content;
	}

	public void setContent(ShapesType content) {
		this.content = content;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	public String getXML(){
		return this.getContent().getXML(this.getStyle());
	}
	
}
