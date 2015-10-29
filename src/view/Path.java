package view;

/**
 * This is the type: "Chemin"
 */
public class Path {
	
	/************************************
	 *	Attributes
	 ************************************/	
	private PencilState style;
	private ShapeState content;
	
	/************************************
	 *	Constructor
	 ************************************/
	public Path(PencilState style, ShapeState content) {
		super();
		this.style = style;
		this.content = content;
	}

	/************************************
	 *	Getters and Setters
	 ************************************/
	public PencilState getStyle() {
		return style;
	}

	public void setStyle(PencilState style) {
		this.style = style;
	}

	public ShapeState getContent() {
		return content;
	}

	public void setContent(ShapeState content) {
		this.content = content;
	}
	
	/************************************
	 *	Methods
	 ************************************/
	public Object getDrawing(){
		return this.getContent().getDrawing(this.getStyle());
	}
	
}
