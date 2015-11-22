package test;

import model.Canvas;
import model.presentation.awt.*;
import model.specific_path.*;
import model.specific_path.Rectangle;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class TestAWT {
    private Object lock = new Object(); // this is the lock to keep awt not be killed
    private AWTFrame awt;

    @Test
    public void createAWT() {
        // Create an awt presentation to draw
        awt = new AWTFrame("new awt", new Canvas(600, 600));
        // title will not be set until createDrawing
        Assert.assertEquals("", awt.getTitle());
        awt.createDrawing();
        Assert.assertEquals("new awt", awt.getTitle());
        Assert.assertEquals(600, awt.getWidth());
        Assert.assertEquals(600, awt.getHeight());
    }

    @Test
    public void testCreateDrawing() {
        // Create an awt presentation to draw
        awt = new AWTFrame("new awt", new Canvas(600, 600));
        // title will not be set until createDrawing
        Assert.assertEquals(awt, awt.createDrawing());
    }

    @Test
    public void testGetShapeState() {
        awt = new AWTFrame("new awt", new Canvas(600, 600));
        Assert.assertTrue(awt.getShapeState(new Circle()) instanceof AWTCircle);
        Assert.assertTrue(awt.getShapeState(new Ellipse()) instanceof AWTEllipse);
        Assert.assertTrue(awt.getShapeState(new Line()) instanceof AWTLine);
        Assert.assertTrue(awt.getShapeState(new Path()) instanceof AWTPath);
        Assert.assertTrue(awt.getShapeState(new Polygone()) instanceof AWTPolygone);
        Assert.assertTrue(awt.getShapeState(new Polyline()) instanceof AWTPolyline);
        Assert.assertTrue(awt.getShapeState(new Rectangle()) instanceof AWTRectangle);
        Assert.assertTrue(awt.getShapeState(new Text()) instanceof AWTText);
    }
}
