package output;

import model.Shape;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface ShapeState {
	/**
	 * Render the shape
	 * @return render result like XML pieces
	 */
	Object getDrawing();

	/**
	 * Set the shape to render
	 * @param shape
	 */
	void setShape(Shape shape) throws Exception;

}
