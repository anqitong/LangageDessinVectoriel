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

        Path2D.Double p2d = new Path2D.Double();
        p2d.moveTo(this.path.getStart().x, this.path.getStart().y);

        Point lastEnd = this.path.getStart(), lastReflect = null;

        for (PathPart part : this.path.getParts()) {
            ArrayList<Point> pts = part.getPoints();
            switch (part.getType()) {
                case Line:
                    if (!pts.isEmpty()) {
                        p2d.lineTo(part.getPoints().get(0).x, part.getPoints().get(0).y);
                        lastEnd = part.getPoints().get(0);
                        lastReflect = null;
                    }
                    break;
                case QuadricBezier:
                    if (pts.size() == 2) {
                        p2d.quadTo(pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        lastEnd = part.getPoints().get(1);
                        lastReflect = null;
                    }
                    break;
                case SmoothBezier:
                    if (pts.size() == 2) {
                        p2d.quadTo(pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        lastEnd = part.getPoints().get(1);
                        lastReflect = null;
                    }
                    break;
                case Curveto:
                    if (pts.size() == 3) {
                        p2d.curveTo(pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y, pts.get(2).x, pts.get(2).y);
                        lastEnd = part.getPoints().get(2);
                        lastReflect = part.getPoints().get(1);
                    }
                    break;
                case SmoothCurveto:
                    if (pts.size() == 2) {
                        if (lastReflect == null) {
                            double[] reflect = this.calculateReflectPoint(new double[]{lastEnd.x, lastEnd.y}
                                    , new double[]{pts.get(1).x, pts.get(1).y}
                                    , new double[]{pts.get(0).x, pts.get(0).y});
                            p2d.curveTo(reflect[0], reflect[1], pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        } else {
                            lastReflect = new Point(lastEnd.x - (lastReflect.x - lastEnd.x), lastEnd.y - (lastReflect.y - lastEnd.y));
                            p2d.curveTo(lastReflect.x, lastReflect.y, pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        }
                    }
                    break;
                case Arc:
                    break;
                default:
            }
        }
        g.draw(p2d);
        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if (shape instanceof Path) {
            this.path = (Path) shape;
        }
    }

    //Compute the dot product AB . AC
    private double dotProduct(double[] pointA, double[] pointB, double[] pointC)
    {
        double[] AB = new double[2];
        double[] BC = new double[2];
        AB[0] = pointB[0] - pointA[0];
        AB[1] = pointB[1] - pointA[1];
        BC[0] = pointC[0] - pointB[0];
        BC[1] = pointC[1] - pointB[1];
        double dot = AB[0] * BC[0] + AB[1] * BC[1];

        return dot;
    }

    //Compute the cross product AB x AC
    private double crossProduct(double[] pointA, double[] pointB, double[] pointC)
    {
        double[] AB = new double[2];
        double[] AC = new double[2];
        AB[0] = pointB[0] - pointA[0];
        AB[1] = pointB[1] - pointA[1];
        AC[0] = pointC[0] - pointA[0];
        AC[1] = pointC[1] - pointA[1];
        double cross = AB[0] * AC[1] - AB[1] * AC[0];

        return cross;
    }

    //Compute the distance from A to B
    private double distance(double[] pointA, double[] pointB)
    {
        double d1 = pointA[0] - pointB[0];
        double d2 = pointA[1] - pointB[1];

        return Math.sqrt(d1 * d1 + d2 * d2);
    }

    //Compute the distance from AB to C
    //if isSegment is true, AB is a segment, not a line.
    private double lineToPointDistance2D(double[] pointA, double[] pointB, double[] pointC, boolean isSegment)
    {
        double dist = crossProduct(pointA, pointB, pointC) / distance(pointA, pointB);
        if (isSegment)
        {
            double dot1 = dotProduct(pointA, pointB, pointC);
            if (dot1 > 0)
                return distance(pointB, pointC);

            double dot2 = dotProduct(pointB, pointA, pointC);
            if (dot2 > 0)
                return distance(pointA, pointC);
        }
        return Math.abs(dist);
    }

    private double[] calculateReflectPoint(double[] pointA, double[] pointB, double[] pointC) {
        double[] result = new double[2];

        double distA = this.lineToPointDistance2D(pointA, pointB, pointC, false);
        double distC = this.distance(pointB, pointC);
        double distB = Math.sqrt(distC*distC - distA*distA);

        if (pointB[0] != pointA[0]) {
            double a = (pointB[1] - pointA[1]) / (pointB[0] - pointA[0]);
            result[0] = distB * a + pointA[0];
            result[1] = distB * a + pointA[1];
        } else { // vertical line
            result[0] = pointA[0];
            result[1] = pointA[1] + distB;
        }

        return result;
    }
}
