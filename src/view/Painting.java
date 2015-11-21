package view;

import language.DrawingTask;
import language.Painter;

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
}
