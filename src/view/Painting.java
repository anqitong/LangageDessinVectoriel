package view;

import language.BasicPainter;
import language.DrawingTask;
import language.Painter;
import model.presentation.awt.AWTFrame;
import model.presentation.xml.SVGFile;

import java.awt.Color;

/**
 * Created by Xiaxing SHI on 21/11/15.
 */
public class Painting implements DrawingTask {
    /**
     * Edit this method to draw whatever you want!
     * But you should only the parameter p.
     * @param p
     */
    @Override
    public void draw(Painter p) {
        p.setName("Painting with language");
        p.setCanvasSize(600, 600);

        p.stroke(1, Color.blue);
        p.fill(Color.red);
        p.circle(30, 30, 30);

        p.stroke(2, Color.darkGray);
        p.ellipse(100, 30, 40, 20);

        p.line(5, 60, 15, 100);

        p.polygone(new int[]{100,200,100}, new int[]{100, 200, 200});

        p.polyline(new int[]{250, 100, 20, 250}, new int[]{100, 300, 300, 200});

        p.rectangle(300, 50, 100, 150);

        p.text(500, 50, "Hello, World!");
    }

    public static void main(String[] args) {
        BasicPainter painter = new BasicPainter();
        Painting painting = new Painting();
        painting.draw(painter);

        AWTFrame awt = new AWTFrame(painter.getName(), painter.getCanvas());
        awt.addShapes(painter.getShapes());
        awt.createDrawing();

        SVGFile svg = new SVGFile(painter.getName());
        svg.setCanvas(painter.getCanvas());
        svg.addShapes(painter.getShapes());
        svg.createDrawing();
        svg.writeSVGFile();
        svg.view();
    }
}
