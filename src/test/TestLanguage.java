package test;

import view.Painting;
import model.Canvas;
import model.presentation.awt.AWTFrame;
import model.presentation.xml.SVGFile;
import language.BasicPainter;

/**
 * This could be the final main class in the project. It read user's drawing task and draw it. Then it shows the
 * painting in JFrame and in a SVG file.
 *
 * Created by Xiaxing SHI on 21/11/15.
 */
public class TestLanguage {

    public static void main(String[] args) {
        BasicPainter painter = new BasicPainter();
        Painting painting = new Painting();
        painting.draw(painter);

        // Create an awt presentation to draw
        AWTFrame awt = new AWTFrame(painter.getName(), new Canvas(600, 600));
        awt.addShapes(painter.getShapes());
        awt.createDrawing();

        // all presentation should also work, so we test them
        SVGFile svg = new SVGFile(painter.getName());
        svg.setCanvas(new Canvas(600, 600));
        svg.addShapes(painter.getShapes());
        svg.createDrawing();
        svg.writeSVGFile();
        svg.view();
    }
}
