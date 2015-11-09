package view;

import model.*;
import model.Canvas;
import model.presentation.awt.AWT;
import model.specific_path.Circle;

import java.awt.*;
import java.awt.Shape;
import java.util.ArrayList;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class DrawAwt {

    public static void main(String args[]) {
        Pencil p = new Pencil(4, new ColorSVG(Color.black.getRGB()));
        Circle c = new Circle(30,30,30);
        c.setColor(new ColorSVG(Color.blue.getRGB()));
        c.setPencil(p);
        ArrayList<model.Shape> shapes = new ArrayList<model.Shape>();
        shapes.add(c);

        AWT awt = new AWT("new awt", new Canvas(200, 200));
        awt.addShapes(shapes);
        awt.display();
    }
}
