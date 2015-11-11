package model.presentation.awt;

import model.Shape;
import model.presentation.ShapeState;
import model.specific_path.Rectangle;

import java.awt.*;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class RectangleAWT implements ShapeState {

    private Rectangle rectangle;
    private StateDelegate delegate;

    public RectangleAWT(Rectangle rectangle, StateDelegate delegate) {
        this.rectangle = rectangle;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        g.setColor(this.rectangle.getColor());
        g.fillRect(this.rectangle.getX(), this.rectangle.getY(), this.rectangle.getWidth(), this.rectangle.getHeight());

        g.setColor(this.rectangle.getPencil().getColor());
        g.setStroke(new BasicStroke(this.rectangle.getPencil().getWidth()));
        g.drawRect(this.rectangle.getX(), this.rectangle.getY(), this.rectangle.getWidth(), this.rectangle.getHeight());

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {

    }
}
