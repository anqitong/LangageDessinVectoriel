package language;

import model.*;
import model.Canvas;
import model.Shape;
import model.specific_path.*;
import model.specific_path.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Xiaxing SHI on 21/11/15.
 */
public class BasicPainter implements Painter, DrawingSource {
    private String name = "My Painting";
    private ColorRBG color = new ColorRBG(Color.BLACK.getRGB());
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
        this.pencil = new Pencil(width, new ColorRBG((color.getRGB())));
    }

    @Override
    public void fill(Color color) {
        this.color = new ColorRBG(color.getRGB());
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
    public void path(LineType type, Point... points) {
        if (points.length == 0) {
            return;
        }

        Point start = points[0];
        ArrayList<PathPart> parts = new ArrayList<PathPart>();
        ArrayList<Point> pts = new ArrayList<Point>(Arrays.asList(points));
        pts.remove(0); // Remove the start point

        parts.add(new PathPart(pts, type));
        Path p = new Path(start, parts);
        addToShapes(p);
    }

    @Override
    public void polygone(Point... points) {
        ArrayList<Point> pts = new ArrayList<Point>(Arrays.asList(points));

        Polygone p = new Polygone(pts);
        addToShapes(p);
    }

    @Override
    public void polyline(Point... points) {
        ArrayList<Point> pts = new ArrayList<Point>(Arrays.asList(points));

        Polygone p = new Polygone(pts);
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
