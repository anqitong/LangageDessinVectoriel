package output.awt;

import model.Shape;
import model.specific_path.Polygone;

import java.awt.*;
import java.util.ArrayList;

import output.ShapeState;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class AWTPolygone implements ShapeState {
    private Polygone polygone;
    private StateDelegate delegate;

    public AWTPolygone(Polygone polygone, StateDelegate delegate) {
        this.polygone = polygone;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        ArrayList<Point> points = this.polygone.getPoints();
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

            g.setColor(this.polygone.getColor());
            g.fillPolygon(xs, ys, points.size()+1);

            g.setColor(this.polygone.getPencil().getColor());
            g.setStroke(new BasicStroke(this.polygone.getPencil().getWidth()));
            g.drawPolygon(xs, ys, points.size()+1);
        }

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Polygone){
            this.polygone = (Polygone) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }
    }
}
