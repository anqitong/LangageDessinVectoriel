package view;

import model.*;
import model.Shape;
import output.awt.AWTFrame;
import output.xml.SVGFile;
import model.specific_path.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 22/11/15.
 */
public class DrawAndShowAWT {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<model.Shape>(); // array for all shapes to draw
        // pencil and color styles that would be used
        Pencil p = new Pencil(3, new ColorRBG(Color.red.getRGB()));
        ColorRBG blue = new ColorRBG(Color.blue.getRGB());
        // Draw a circle
        Circle c = new Circle(30,30,30);
        c.setColor(blue);
        c.setPencil(p);
        shapes.add(c);
        // Draw an ellipse
        Ellipse e = new Ellipse(100, 30, 40, 20);
        e.setColor(blue);
        e.setPencil(p);
        shapes.add(e);
        // Draw a line
        Line l = new Line(5, 60, 15, 100);
        l.setPencil(p);
        shapes.add(l);
        // Draw a polygon
        Polygon polygon = new Polygon();
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(200, 200));
        points.add(new Point(100, 200));
        polygon.setPoints(points);
        polygon.setColor(blue);
        polygon.setPencil(p);
        shapes.add(polygon);
        // Draw a polyline
        Polyline polyline = new Polyline();
        points = new ArrayList<Point>();
        points.add(new Point(250, 100));
        points.add(new Point(100, 300));
        points.add(new Point(20, 300));
        points.add(new Point(250, 200));
        polyline.setPoints(points);
        polyline.setPencil(p);
        shapes.add(polyline);
        // Draw a rectangle
        model.specific_path.Rectangle r = new model.specific_path.Rectangle(300, 50, 100, 150);
        r.setPencil(p);
        r.setColor(blue);
        shapes.add(r);
        // Draw some words
        Text t = new Text(500, 50, "Hello, World!");
        t.setPencil(p);
        shapes.add(t);
        Text bt = new Text(500, 65, "Hello, World!");
        bt.setPencil(new Pencil(10, blue));
        shapes.add(bt);

        // Path
        Pencil pred = new Pencil(3, new ColorRBG(Color.red.getRGB()));

        // Create a red line
        Path path = new Path();
        path.setStart(new Point(100, 550));
        path.setPencil(pred);
        ArrayList<PathPart> parts = new ArrayList<PathPart>();
        parts.add(new PathPart(new Point(250, 250), LineType.Line));
        path.setParts(parts);
        shapes.add(path);

        // Create another red line that touch the first one
        path = new Path();
        path.setStart(new Point(250, 250));
        path.setPencil(pred);
        parts = new ArrayList<PathPart>();
        parts.add(new PathPart(new Point(400, 550), LineType.Line));
        path.setParts(parts);
        shapes.add(path);

        Pencil pgreen = new Pencil(3, new ColorRBG(Color.green.getRGB()));
        // Create a horizontal green line
        path = new Path();
        path.setStart(new Point(175, 400));
        path.setPencil(pgreen);
        parts = new ArrayList<PathPart>();
        parts.add(new PathPart(new Point(325, 400), LineType.Line));
        path.setParts(parts);
        shapes.add(path);

        Pencil pblue = new Pencil(3, new ColorRBG(Color.blue.getRGB()));
        // Create a bezier blue line
        path = new Path();
        path.setStart(new Point(100, 550));
        path.setPencil(pblue);
        parts = new ArrayList<PathPart>();
        PathPart bez = new PathPart(new Point(250, 250), LineType.QuadricBezier);
        bez.getPoints().add(new Point(400, 550));
        parts.add(bez);
        path.setParts(parts);
        shapes.add(path);

        // Curve
        Path curve = new Path();
        curve.setPencil(p);
        curve.setStart(new Point(410, 480));
        parts = new ArrayList<PathPart>();
        ArrayList<Point> pPoints = new ArrayList<Point>();
        pPoints.add(new Point(440, 410));
        pPoints.add(new Point(465, 410));
        pPoints.add(new Point(495, 480));
        PathPart part = new PathPart(pPoints, LineType.Curveto);
        parts.add(part);
        pPoints = new ArrayList<Point>();
        pPoints.add(new Point(550, 550));
        pPoints.add(new Point(580, 500));
        part = new PathPart(pPoints, LineType.SmoothCurveto);
        parts.add(part);
        curve.setParts(parts);
        shapes.add(curve);

        // Quadratic Bezier
        Path qb = new Path();
        qb.setPencil(p);
        qb.setStart(new Point(410, 480));
        parts = new ArrayList<PathPart>();
        pPoints = new ArrayList<Point>();
        pPoints.add(new Point(452, 410));
        pPoints.add(new Point(495, 480));
        part = new PathPart(pPoints, LineType.QuadricBezier);
        parts.add(part);
        pPoints = new ArrayList<Point>();
        pPoints.add(new Point(580, 480));
        part = new PathPart(pPoints, LineType.SmoothBezier);
        parts.add(part);
        qb.setParts(parts);
        shapes.add(qb);

        // Create an awt presentation to draw
        AWTFrame awt = new AWTFrame("new awt", new model.Canvas(600, 600));
        awt.addShapes(shapes);
        awt.createDrawing();

        // all presentation should also work, so we test them
        SVGFile svg = new SVGFile("svgAndAwt");
        svg.setCanvas(new model.Canvas(600, 600));
        svg.addShapes(shapes);
        svg.createDrawing();
        svg.writeSVGFile();
        svg.view();
    }
}
