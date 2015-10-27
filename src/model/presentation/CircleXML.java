package model.presentation;

import model.Pencil;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public class CircleXML implements ShapeState {
    private Circle shape;

    CircleXML(Circle shape) {
        this.setShape(shape);
    }

    @Override
    public Object getDrawing(Pencil pencil) {
        String pencilXML = "stroke=\""+pencil.getColor()+"\" stroke-width=\""+pencil.getWidth()+"\"";
        return "<circle cx=\""+this.shape.getCenter_x()+"\" cy=\""+this.shape.getCenter_y()+"\" r=\""+this.shape.getRadius()+"\" fill=\""+pencil.getColor()+"\" "+pencilXML+" />";
    }

    @Override
    public void setShape(Shape shape) {
        if (shape instanceof Circle)
            this.shape = (Circle)shape;
        else
            this.shape = new Circle(0,0,0);
    }
}
