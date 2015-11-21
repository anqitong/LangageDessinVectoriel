package language;

import model.*;
import model.Canvas;
import model.Shape;
import model.specific_path.*;
import model.specific_path.Rectangle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 21/11/15.
 */
public class BasicPainter implements Painter, DrawingSource {
    private String name = "My Painting";
    private ColorSVG color = new ColorSVG(Color.BLACK.getRGB());
    private Pencil pencil = new Pencil(1, color);
    private Canvas canvas = new Canvas(1024, 1024);

    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    @Override
    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    @Override
    public void setCanvasSize(int width, int height) {
        this.canvas.setWidth(width);
        this.canvas.setHeight(height);
    }

    @Override
    public void stroke(int width, Color color) {
        this.pencil = new Pencil(width, new ColorSVG((color.getRGB())));
    }

    @Override
    public void fill(Color color) {
        this.color = new ColorSVG(color.getRGB());
    }

    @Override
    public void circle(int x, int y, int r) {
        Circle c = new Circle(x, y, r);
        addToShapes(c);
    }

    @Override
    public void ellipse(int x, int y, int rx, int ry) {
        Ellipse e = new Ellipse(x, y, rx, ry);
        addToShapes(e);
    }

    @Override
    public void line(int x1, int y1, int x2, int y2) {
        Line l = new Line(x1, y1, x2, y2);
        addToShapes(l);

    }

    @Override
    public void path(LineType type, int[] xs, int[] ys) {
        if (xs.length == 0 || xs.length != ys.length) {
            return;
        }

        Point start = new Point(xs[0], ys[0]);
        ArrayList<PathPart> parts = new ArrayList<PathPart>();
        ArrayList<Point> points = new ArrayList<Point>();

        for (int i=1; i<xs.length; ++i) {
            points.add(new Point(xs[i], ys[i]));
        }
        parts.add(new PathPart(points, type));
        Path p = new Path(start, parts);
        addToShapes(p);
    }

    @Override
    public void polygone(int[] xs, int[] ys) {
        if (xs.length == 0 || xs.length != ys.length) {
            return;
        }

        ArrayList<Point> points = new ArrayList<Point>();

        for (int i=0; i<xs.length; ++i) {
            points.add(new Point(xs[i], ys[i]));
        }
        Polygone p = new Polygone(points);
        addToShapes(p);
    }

    @Override
    public void polyline(int[] xs, int[] ys) {
        if (xs.length == 0 || xs.length != ys.length) {
            return;
        }

        ArrayList<Point> points = new ArrayList<Point>();

        for (int i=0; i<xs.length; ++i) {
            points.add(new Point(xs[i], ys[i]));
        }
        Polyline p = new Polyline(points);
        addToShapes(p);
    }

    @Override
    public void rectangle(int x, int y, int width, int height) {
        Rectangle r = new Rectangle(x, y, height, width);
        addToShapes(r);

    }

    @Override
    public void text(int x, int y, String text) {
        Text t = new Text(x, y, text);
        addToShapes(t);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Canvas getCanvas() {
        return this.canvas;
    }

    @Override
    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    private void addToShapes(Shape shape) {
        shape.setColor(color);
        shape.setPencil(pencil);
        shapes.add(shape);
    }
}
