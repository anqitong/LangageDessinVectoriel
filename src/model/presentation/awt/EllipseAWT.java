package model.presentation.awt;

import model.Shape;
import model.presentation.ShapeState;
import model.specific_path.Ellipse;

import java.awt.*;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class EllipseAWT implements ShapeState {
    private Ellipse ellipse;
    private StateDelegate delegate;

    public EllipseAWT(Ellipse ellipse, StateDelegate delegate) {
        this.ellipse = ellipse;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        g.setColor(this.ellipse.getColor());
        g.fillOval(this.ellipse.getCenter_x(), this.ellipse.getCenter_y(), this.ellipse.getRadius_x()*2, this.ellipse.getRadius_y()*2);

        g.setColor(this.ellipse.getPencil().getColor());
        g.setStroke(new BasicStroke(this.ellipse.getPencil().getWidth()));
        g.drawOval(this.ellipse.getCenter_x(), this.ellipse.getCenter_y(), this.ellipse.getRadius_x()*2, this.ellipse.getRadius_y()*2);

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {

    }
}