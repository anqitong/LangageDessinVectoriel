package model.presentation;

import model.Pencil;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface ShapeState {
    Object getDrawing(Pencil pencil);
    void setShape(Shape shape);
}
