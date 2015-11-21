package model.presentation.awt;

import model.Shape;
import model.presentation.ShapeState;
import model.specific_path.LineType;
import model.specific_path.Path;
import model.specific_path.PathPart;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 21/11/15.
 */
public class AWTPath implements ShapeState {
    private Path path;
    private StateDelegate delegate;

    public AWTPath(Path path, StateDelegate delegate) {
        this.delegate = delegate;
        this.path = path;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();
        g.setColor(this.path.getPencil().getColor());
        g.setStroke(new BasicStroke(this.path.getPencil().getWidth()));

        Path2D.Double path2D = new Path2D.Double();
        path2D.moveTo(this.path.getStart().getX(), this.path.getStart().getY());

        for (PathPart part : this.path.getParts()) {
            ArrayList<Point> points = part.getPoints();
            switch (part.getType()) {
                case Line:
                    if (!points.isEmpty())
                        path2D.lineTo(part.getPoints().get(0).getX(), part.getPoints().get(0).getY());
                    break;
                case QuadricBezier:
                    if (points.size() >= 2)
                        path2D.quadTo(points.get(0).getX(), points.get(0).getY(), points.get(1).getX(), points.get(1).getY());
                    break;
                case SmoothBezier:
                    break;
                case Curveto:
                    break;
                case SmoothCurveto:
                    break;
                case Arc:
                    break;
                default:
            }
        }
        g.draw(path2D);
        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if (shape instanceof Path) {
            this.path = (Path) shape;
        }
    }
}
