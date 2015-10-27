package model.presentation;

import model.Pencil;
import model.ShapesType;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface ShapeState {
    /**
     * Render the shape
     * @param pencil the pencil to use to render the shape
     * @return render result like XML pieces
     */
    Object getDrawing(Pencil pencil);

    /**
     * Set the shape to render
     * @param shape shape to render
     */
    void setShape(ShapesType shape);
}
