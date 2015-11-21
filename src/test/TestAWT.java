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
        // Draw a polygone
        Polygone polygone = new Polygone();
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(200, 200));
        points.add(new Point(100, 200));
        polygone.setPoints(points);
        polygone.setColor(blue);
        polygone.setPencil(p);
        shapes.add(polygone);
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
        Rectangle r = new Rectangle(300, 50, 100, 150);
        r.setPencil(p);
        r.setColor(blue);
        shapes.add(r);
        // Draw some words
        Text t = new Text(500, 50, "Hello, World!");
        t.setPencil(p);
        shapes.add(t);

        // Path
        Pencil pred = new Pencil(3, new ColorSVG(Color.red.getRGB()));

        // Create a red line
        Path path2 = new Path();
        path2.setStart(new Point(100, 550));
        path2.setPencil(pred);
        ArrayList<PathPart> parts2 = new ArrayList<PathPart>();
        parts2.add(new PathPart(new Point(250, 250), LineType.Line));
        path2.setParts(parts2);

        // Create another red line that touch the first one
        Path path3 = new Path();
        path3.setStart(new Point(250, 250));
        path3.setPencil(pred);
        ArrayList<PathPart> parts3 = new ArrayList<PathPart>();
        parts3.add(new PathPart(new Point(400, 550), LineType.Line));
        path3.setParts(parts3);

        Pencil pgreen = new Pencil(3, new ColorSVG(Color.green.getRGB()));
        // Create a horizontal green line
        Path path4 = new Path();
        path4.setStart(new Point(175, 400));
        path4.setPencil(pgreen);
        ArrayList<PathPart> parts4 = new ArrayList<PathPart>();
        parts4.add(new PathPart(new Point(325, 400), LineType.Line));
        path4.setParts(parts4);

        Pencil pblue = new Pencil(3, new ColorSVG(Color.blue.getRGB()));
        // Create a bezier blue line
        Path path5 = new Path();
        path5.setStart(new Point(100, 550));
        path5.setPencil(pblue);
        ArrayList<PathPart> parts5 = new ArrayList<PathPart>();
        PathPart bez = new PathPart(new Point(250, 250), LineType.QuadricBezier);
        bez.getPoints().add(new Point(400, 550));
        parts5.add(bez);
        path5.setParts(parts5);

        //Add all the lines together
        shapes.add(path2);
        shapes.add(path3);
        shapes.add(path4);
        shapes.add(path5);

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
