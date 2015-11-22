package model.presentation.awt;

import model.Shape;
import model.presentation.ShapeState;
import model.specific_path.Polyline;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class AWTPolyline implements ShapeState {

    private Polyline polyline;
    private StateDelegate delegate;

    public AWTPolyline(Polyline polyline, StateDelegate delegate) {
        this.polyline = polyline;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        ArrayList<Point> points = this.polyline.getPoints();
        if (points != null) {
            int[] xs = new int[points.size()];
            int[] ys = new int[points.size()];
            for (int i=0; i<points.size(); ++i) {
                Point p = points.get(i);
                xs[i] = p.x;
                ys[i] = p.y;
            }

            g.setColor(this.polyline.getPencil().getColor());
            g.setStroke(new BasicStroke(this.polyline.getPencil().getWidth()));
            g.drawPolyline(xs, ys, points.size());
        }

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Polyline){
            this.polyline = (Polyline) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }
    }
}
