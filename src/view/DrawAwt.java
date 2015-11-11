package view;

import model.*;
import model.Canvas;
import model.presentation.awt.AWT;
import model.specific_path.Circle;
import model.specific_path.Ellipse;
import model.specific_path.Line;
import sun.plugin2.util.ColorUtil;

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

        AWT awt = new AWT("new awt", new Canvas(1024, 720));
        awt.addShapes(shapes);
        awt.display();
    }
}
