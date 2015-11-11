package model.presentation.awt;

import model.Canvas;
import model.Shape;
import model.presentation.Presentation;
import model.presentation.ShapeState;
import model.specific_path.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class AWT extends Frame implements Presentation, StateDelegate {

    private String name;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private Canvas canvas;
    private Graphics2D g2d = null;

    public AWT(String name, Canvas canvas) {
        this.setCanvas(canvas);
        this.setName(name);
    }

    public AWT(String name) {
        this(name, new Canvas(1024, 1024));
    }

    @Override
    public void addShapes(List<Shape> shapes) {
        if (shapes != null)
            this.shapes.addAll(shapes);
    }

    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void display() {
        this.setSize(canvas.getWidth(), canvas.getHeight());
        this.setName(name);
        this.setTitle(name);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    @Override
    public ShapeState getShapeState(Shape shape) {
        ShapeState state = null;

        switch (shape.getName()) {
            case Circle:
                state = new CircleAWT((Circle)shape, this);
                break;
            case Ellipse:
                state = new EllipseAWT((Ellipse)shape, this);
                break;
            case Line:
//                state = new LineXML((Line)shape);
                break;
            case Path:
//                state = new PathXML((Path)shape);
                break;
            case Polygone:
//                state = new PolygoneXML((Polygone)shape);
                break;
            case Polyline:
//                state = new PolylineXML((Polyline)shape);
                break;
            case Rectangle:
//                state = new RectangleXML((Rectangle)shape);
                break;
            case Text:
//                state = new TextXML((Text)shape);
                break;
            default:
        }
        return state;
    }

    @Override
    public void paint(Graphics g) {
        this.g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            this.getShapeState(shape).getDrawing();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return this.g2d;
    }
}
