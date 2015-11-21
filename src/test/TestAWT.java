package test;

import model.*;
import model.Canvas;
import model.Shape;
import model.presentation.awt.AWTFrame;
import model.presentation.xml.SVGFile;
import model.specific_path.*;
import model.specific_path.Rectangle;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class TestAWT {
    private Object lock = new Object(); // this is the lock to keep awt not be killed
    private AWTFrame awt;
    @Test
    public void awt() {
        ArrayList<model.Shape> shapes = new ArrayList<model.Shape>(); // array for all shapes to draw
        // pencil and color styles that would be used
        Pencil p = new Pencil(4, new ColorSVG(Color.red.getRGB()));
        ColorSVG blue = new ColorSVG(Color.blue.getRGB());
//        // Draw a circle
//        Circle c = new Circle(30,30,30);
//        c.setColor(blue);
//        c.setPencil(p);
//        shapes.add(c);
//        // Draw an ellipse
//        Ellipse e = new Ellipse(100, 30, 40, 20);
//        e.setColor(blue);
//        e.setPencil(p);
//        shapes.add(e);
//        // Draw a line
//        Line l = new Line(5, 60, 15, 100);
//        l.setPencil(p);
//        shapes.add(l);
//        // Draw a polygone
//        Polygone polygone = new Polygone();
//        ArrayList<Point> points = new ArrayList<Point>();
//        points.add(new Point(100, 100));
//        points.add(new Point(200, 200));
//        points.add(new Point(100, 200));
//        polygone.setPoints(points);
//        polygone.setColor(blue);
//        polygone.setPencil(p);
//        shapes.add(polygone);
//        // Draw a polyline
//        Polyline polyline = new Polyline();
//        points = new ArrayList<Point>();
//        points.add(new Point(250, 100));
//        points.add(new Point(100, 300));
//        points.add(new Point(20, 300));
//        points.add(new Point(250, 200));
//        polyline.setPoints(points);
//        polyline.setPencil(p);
//        shapes.add(polyline);
//        // Draw a rectangle
//        Rectangle r = new Rectangle(300, 50, 100, 150);
//        r.setPencil(p);
//        r.setColor(blue);
//        shapes.add(r);
//        // Draw some words
//        Text t = new Text(500, 50, "Hello, World!");
//        t.setPencil(p);
//        shapes.add(t);

        // Path
        Pencil pred = new Pencil(3, new ColorSVG(Color.red.getRGB()));

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

        Pencil pgreen = new Pencil(3, new ColorSVG(Color.green.getRGB()));
        // Create a horizontal green line
        path = new Path();
        path.setStart(new Point(175, 400));
        path.setPencil(pgreen);
        parts = new ArrayList<PathPart>();
        parts.add(new PathPart(new Point(325, 400), LineType.Line));
        path.setParts(parts);
        shapes.add(path);

        Pencil pblue = new Pencil(3, new ColorSVG(Color.blue.getRGB()));
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
        curve.setStart(new Point(10, 80));
        parts = new ArrayList<PathPart>();
        ArrayList<Point> pPoints = new ArrayList<Point>();
        pPoints.add(new Point(40, 10));
        pPoints.add(new Point(65, 10));
        pPoints.add(new Point(95, 80));
        PathPart part = new PathPart(pPoints, LineType.Curveto);
        parts.add(part);
        pPoints = new ArrayList<Point>();
        pPoints.add(new Point(150, 150));
        pPoints.add(new Point(180, 100));
        part = new PathPart(pPoints, LineType.SmoothCurveto);
        parts.add(part);
        curve.setParts(parts);
        shapes.add(curve);

        // Create an awt presentation to draw
        awt = new AWTFrame("new awt", new Canvas(600, 600));
        awt.addShapes(shapes);
        awt.createDrawing();

        // all presentation should also work, so we test them
//        SVGFile svg = new SVGFile("svgAndAwt");
//        svg.setCanvas(new Canvas(600, 600));
//        svg.addShapes(shapes);
//        svg.createDrawing();
//        svg.writeSVGFile();
//        svg.view();

        Thread thread = new Thread() {
            public void run() {
                synchronized(lock) {
                    while (awt.isVisible())
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("Working now");
                }
            }
        };
        thread.start();

        awt.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    awt.setVisible(false);
                    lock.notify();
                }
            }

        });

        try {
            thread.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
