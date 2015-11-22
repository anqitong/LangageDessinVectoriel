package test;

import model.specific_path.Text;
import org.junit.Assert;
import org.junit.Test;
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

    @Test
    public void readPaintingScript() {
        BasicPainter painter = new BasicPainter();
        Painting painting = new Painting();
        painting.draw(painter);

        Assert.assertEquals("Painting with language", painter.getName());
        Assert.assertEquals(600, painter.getCanvas().getWidth());
        Assert.assertEquals(600, painter.getCanvas().getHeight());
        Assert.assertEquals(7, painter.getShapes().size());
        Assert.assertTrue(painter.getShapes().get(6) instanceof Text);
        Assert.assertEquals("Hello, World!", ((Text)painter.getShapes().get(6)).getText());
    }

    @Test
    public void generateSVG() {
        BasicPainter painter = new BasicPainter();
        Painting painting = new Painting();
        painting.draw(painter);

        SVGFile svg = new SVGFile(painter.getName());
        svg.setCanvas(painter.getCanvas());
        svg.addShapes(painter.getShapes());
        svg.createDrawing();
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"600\" width=\"600\">\n" +
                "\t<circle cx=\"30\" cy=\"30\" r=\"30\" fill=\"rgb(255,0,0)\" stroke=\"rgb(0,0,255)\" stroke-width=\"1\" />\n" +
                "\t<circle cx=\"100\" cy=\"30\" rx=\"40\" ry=\"20\" fill=\"rgb(255,0,0)\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\" />\n" +
                "\t<line x1=\"5\" y1=\"60\" x2=\"15\" y2=\"100\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\" />\n" +
                "\t<polygon points=\" 100,100 200,200 100,200\" fill=\"rgb(255,0,0)\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\" />\n" +
                "\t<polyline points=\" 250,100 100,300 20,300 250,200\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\" />\n" +
                "\t<rect x=\"300\" y=\"50\" width=\"100\" height=\"150\" fill=\"rgb(255,0,0)\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\" />\n" +
                "\t<text x=\"500\" y=\"50\" stroke=\"rgb(64,64,64)\" stroke-width=\"2\">Hello, World!</text>\n" +
                "</svg>";
        Assert.assertEquals(xml, svg.getXmlcontent());
    }

    @Test
    public void generateAWT() {
        BasicPainter painter = new BasicPainter();
        Painting painting = new Painting();
        painting.draw(painter);

        AWTFrame awt = new AWTFrame(painter.getName(), painter.getCanvas());
        awt.addShapes(painter.getShapes());
        awt.createDrawing();
        Assert.assertTrue(awt.isVisible());
    }
}
