package output.awt;

import model.Shape;
import model.specific_path.Polygon;

import java.awt.*;
import java.util.ArrayList;

import output.ShapeState;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class AWTPolygon implements ShapeState {
    private Polygon polygon;
    private StateDelegate delegate;

    public AWTPolygon(Polygon polygon, StateDelegate delegate) {
        this.polygon = polygon;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        ArrayList<Point> points = this.polygon.getPoints();
        if (points != null) {
            // xs & ys should have one more space than points to store the first point at the end of array
            int[] xs = new int[points.size() + 1];
            int[] ys = new int[points.size() + 1];
            for (int i=0; i<points.size(); ++i) {
                Point p = points.get(i);
                xs[i] = p.x;
                ys[i] = p.y;
            }
            xs[points.size()] = points.get(0).x;
            ys[points.size()] = points.get(0).y;

            g.setColor(this.polygon.getColor());
            g.fillPolygon(xs, ys, points.size()+1);

            g.setColor(this.polygon.getPencil().getColor());
            g.setStroke(new BasicStroke(this.polygon.getPencil().getWidth()));
            g.drawPolygon(xs, ys, points.size()+1);
        }

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Polygon){
            this.polygon = (Polygon) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }
    }
}
