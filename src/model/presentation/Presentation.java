package model.presentation;

import model.ShapesName;

import java.util.List;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface Presentation {
    void addShapes(List<Shape> shapes);
    void display();
    ShapeState getShapeState(Shape shape);
}
