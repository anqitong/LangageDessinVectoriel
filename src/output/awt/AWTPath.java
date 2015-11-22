package output.awt;

import model.Shape;
import output.ShapeState;
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

    // Here draw paths
    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();
        g.setColor(this.path.getPencil().getColor());
        g.setStroke(new BasicStroke(this.path.getPencil().getWidth()));

        // We use built-in class Path2D.Double to draw paths
        Path2D.Double p2d = new Path2D.Double();
        p2d.moveTo(this.path.getStart().x, this.path.getStart().y);

        // These are flags for drawing certain parts
        Point lastEnd = this.path.getStart(); // last ending point drawn
        Point lastReflect = null; // last control/reflect point for curves drawn
        Point lastControl = null; // last control point for quadric beziers drawn

        // Draw each part of the path
        for (PathPart part : this.path.getParts()) {
            ArrayList<Point> pts = part.getPoints();
            switch (part.getType()) {
                case Line:
                    if (pts.size() == 1) {
                        // point 0 is the ending point
                        p2d.lineTo(part.getPoints().get(0).x, part.getPoints().get(0).y);
                        lastEnd = part.getPoints().get(0);
                        lastReflect = null;
                        lastControl = null;
                    }
                    break;
                case QuadricBezier:
                    if (pts.size() == 2) {
                        // point 0 is a control point, point 1 is the ending point
                        p2d.quadTo(pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        lastEnd = part.getPoints().get(1);
                        lastReflect = pts.get(0);
                        lastControl = pts.get(0);
                    }
                    break;
                case SmoothBezier:
                    if (pts.size() == 1 && lastControl != null) {
                        // point 0 is the ending point, and this control point is calculated by the last control point
                        lastControl = new Point(lastEnd.x - (lastControl.x - lastEnd.x), lastEnd.y - (lastControl.y - lastEnd.y));
                        p2d.quadTo(lastControl.x, lastControl.y, pts.get(0).x, pts.get(0).y);

                        lastEnd = part.getPoints().get(0);
                        lastReflect = null;
                    }
                    break;
                case Curveto:
                    if (pts.size() == 3) {
                        // point 0 & 1 are control points, point 2 is the ending point
                        p2d.curveTo(pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y, pts.get(2).x, pts.get(2).y);
                        lastEnd = part.getPoints().get(2);
                        lastReflect = part.getPoints().get(1);
                        lastControl = null;
                    }
                    break;
                case SmoothCurveto:
                    if (pts.size() == 2) {
                        // point 0 is the 2nd control point, point 1 is the ending point
                        // the 1st control point is calculated
                        if (lastReflect == null) {
                            // calculate the 1st control point by the 2nd one
                            double[] reflect = this.calculateReflectPoint(new double[]{lastEnd.x, lastEnd.y}
                                    , new double[]{pts.get(1).x, pts.get(1).y}
                                    , new double[]{pts.get(0).x, pts.get(0).y});
                            lastReflect = new Point((int) reflect[0], (int)reflect[1]);
                            p2d.curveTo(reflect[0], reflect[1], pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        } else {
                            // calculate the 1st control point by the last one
                            lastReflect = new Point(lastEnd.x - (lastReflect.x - lastEnd.x), lastEnd.y - (lastReflect.y - lastEnd.y));
                            p2d.curveTo(lastReflect.x, lastReflect.y, pts.get(0).x, pts.get(0).y, pts.get(1).x, pts.get(1).y);
                        }
                        lastEnd = pts.get(1);
                        lastControl = null;
                    }
                    break;
                case Arc:
                    // We can not implement this.
                    // TODO
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

    // Compute that missing control point for SmoothCurveto when there is not a curveto or QuadricBezier before.
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
