package language;

import model.Canvas;
import model.Shape;

import java.util.ArrayList;

/**
 * This defined a data source for a painting.
 *
 * Created by Xiaxing SHI on 21/11/15.
 */
public interface DrawingSource {
    String getName();
    Canvas getCanvas();
    ArrayList<Shape> getShapes();
}
