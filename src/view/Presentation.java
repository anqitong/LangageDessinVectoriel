package view;

import model.Canvas;
import model.Shape;

import java.util.List;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public interface Presentation {

    /**
     * Add shapes for the presentation (or image/painting). Concrete ShapeStates would be created according to these
     * shapes.
     * @param shapes shapes to add to the presentation
     */
    void addShapes(List<Shape> shapes);

    /**
     * Set Canvas
     * @param canvas
     */
    void setCanvas(Canvas canvas);

    /**
     * To create real presentation like svg file and display it to user. Here is where to call
     * <code>this.getShapeState(aShape)</code> to create concrete ShapeStates and render Shapes in list.
     */
    void display();

    /**
     * This method is a tool to create concrete ShapeStates according to the type of shapes given. A typical implementation is to
     * <code>switch (shape.getName())</code>
     * @param shape the shape to render by ShapeState
     * @return a concrete ShapeState object that can render shape
     */
    ShapeState getShapeState(Shape shape);
}
