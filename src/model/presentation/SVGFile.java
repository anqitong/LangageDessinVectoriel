package model.presentation;

import model.Pencil;

import java.util.List;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public class SVGFile implements Presentation {
    private List<Shape> shapes;
    private Pencil pencil;

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    @Override
    public void addShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void display() {
        // TODO: create an empty svg file
        for (Shape shape : this.shapes) {
            String xml = (String) this.getShapeState(shape).getDrawing(pencil);
            // TODO: add xml to this svg
        }
        // TODO: open a navigator to display this svg
    }

    @Override
    public ShapeState getShapeState(Shape shape) {
        ShapeState state = null;

        switch (shape.getName()) {
            case Circle:
                state = new CircleXML((Circle)shape);
        }

        return state;
    }
}
