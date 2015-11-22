package language;

import model.specific_path.LineType;
import java.awt.*;

/**
 * This defines what a user can do for drawing things
 */
public interface Painter {
    /**
     * Give the painting a name
     * @param name
     */
    void setName(String name);

    /**
     * Set the size of the painting
     * @param width
     * @param height
     */
    void setCanvasSize(int width, int height);

    /**
     * Determine to show the painting in a Java window or not
     * @param isWindow
     */
    void setShowInWindow(boolean isWindow);

    /**
     * Determine to save the painting as a SVG file or not.
     * Saved file can be found in files/
     * @param isSvg
     */
    void setSaveAsSVG(boolean isSvg);

    /**
     * Set the stroke to be used
     * @param width width of stroke
     * @param color color of stroke
     */
    void stroke(int width, Color color);

    /**
     * Set the filling color to be used
     * @param color color to fill
     */
    void fill(Color color);

    /**
     * Draw a circle
     * @param x center point's x value
     * @param y center point's y value
     * @param r radius
     */
    void circle(int x, int y, int r);

    /**
     * Draw an ellipse
     * @param x center point's x value
     * @param y center point's y value
     * @param rx horizontal radius
     * @param ry vertical radius
     */
    void ellipse(int x, int y, int rx, int ry);

    /**
     * Draw a line from point(x1, y1) to point(x2, y2)
     * @param x1 x value of starting point
     * @param y1 y value of starting point
     * @param x2 x value of ending point
     * @param y2 y value of ending point
     */
    void line(int x1, int y1, int x2, int y2);

    /**
     * Draw a simple path
     * @param type type of path
     * @param points points needed
     */
    void path(LineType type, Point... points);

    /**
     * Draw a path
     * @param start point to start
     * @param types types for all parts by drawing order
     * @param points points needed for all parts by drawing order
     */
    void path(Point start, LineType[] types, Point[][] points);

    /**
     * Draw a polygon
     * @param points points for apexes, DO NOT REPEAT the starting point at the end
     */
    void polygon(Point... points);

    /**
     * Draw a polyline
     * @param points points for apexes
     */
    void polyline(Point... points);

    /**
     * Draw a rectangle
     * @param x x value of the top-left point
     * @param y y value of the top-left point
     * @param width
     * @param height
     */
    void rectangle(int x, int y, int width, int height);

    /**
     * Draw texts
     * @param x x value of the top-left point
     * @param y x value of the top-left point
     * @param text
     */
    void text(int x, int y, String text);
}
