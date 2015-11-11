package view;

import model.*;
import model.Canvas;
import model.presentation.awt.AWT;
import model.specific_path.*;

import java.awt.*;
import java.awt.Shape;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class DrawAwt {

    public static void main(String args[]) {
        ArrayList<model.Shape> shapes = new ArrayList<model.Shape>();

        Pencil p = new Pencil(4, new ColorSVG(Color.red.getRGB()));
        ColorSVG blue = new ColorSVG(Color.blue.getRGB());

        Circle c = new Circle(30,30,30);
        c.setColor(blue);
        c.setPencil(p);
        shapes.add(c);

        Ellipse e = new Ellipse(100, 30, 40, 20);
        e.setColor(blue);
        e.setPencil(p);
        shapes.add(e);

        Line l = new Line(5, 60, 15, 100);
        l.setPencil(p);
        shapes.add(l);

        Polygone polygone = new Polygone();
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(200, 200));
        points.add(new Point(100, 200));
        polygone.setPoints(points);
        polygone.setColor(blue);
        polygone.setPencil(p);
        shapes.add(polygone);

        Polyline polyline = new Polyline();
        points = new ArrayList<Point>();
        points.add(new Point(250, 100));
        points.add(new Point(100, 300));
        points.add(new Point(20, 300));
        points.add(new Point(250, 200));
        polyline.setPoints(points);
        polyline.setPencil(p);
        shapes.add(polyline);

        AWT awt = new AWT("new awt", new Canvas(1024, 720));
        awt.addShapes(shapes);
        awt.display();
    }
}
