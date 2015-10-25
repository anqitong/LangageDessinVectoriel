package Model;

/**
 * This is the type: "Chemin"
 */
public class Path {

	private Pencil style;
	private ShapesType content;
	
	public Path(Pencil style, ShapesType content) {
		super();
		this.style = style;
		this.content = content;
	}

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
	
}
