package view;

import model.Shape;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface ShapeState {
    /**
     * Render the shape
     * @param pencil the pencil to use to render the shape
     * @return render result like XML pieces
     */
    Object getDrawing(PencilState pencil);

    /**
     * Set the shape to render
     * @param shape
     */
    void setShape(Shape shape) throws Exception;
    
}
