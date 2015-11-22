package output.awt;

import model.Canvas;
import model.Shape;
import model.specific_path.*;

import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import output.Presentation;
import output.ShapeState;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class AWTFrame extends Frame implements Presentation, StateDelegate {

    private String name;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private Canvas canvas;
    private Graphics2D g2d = null;

    public AWTFrame(String name, Canvas canvas) {
    	this.setCanvas(canvas);
        this.setName(name);
    }

    public AWTFrame(String name) {
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
    public Object createDrawing() {
        this.setSize(canvas.getWidth(), canvas.getHeight());
        this.setName(name);
        this.setTitle(name);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                windowEvent.getWindow().dispose();
            }
        });
        
        this.setVisible(true);
        return this;
    }

    @Override
    public ShapeState getShapeState(Shape shape) {
        ShapeState state = null;

        switch (shape.getName()) {
            case Circle:
                state = new AWTCircle((Circle)shape, this);
                break;
            case Ellipse:
                state = new AWTEllipse((Ellipse)shape, this);
                break;
            case Line:
                state = new AWTLine((Line)shape, this);
                break;
            case Path:
                // TODO: Implement Class AWTPath
                break;
            case Polygone:
                state = new AWTPolygone((Polygone)shape, this);
                break;
            case Polyline:
                state = new AWTPolyline((Polyline)shape, this);
                break;
            case Rectangle:
                state = new AWTRectangle((Rectangle)shape, this);
                break;
            case Text:
                state = new AWTText((Text)shape, this);
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

    @Override
    public Presentation clone() {
        // TODO
        return null;
    }

    @Override
    public void insert(Presentation p) {
        //TODO
    }
}
