package language;

import model.specific_path.LineType;
import java.awt.*;

/**
 * This defined what a user can do for drawing things
 */
public interface Painter {
    void setName(String name);
    void setCanvasSize(int width, int height);
    void stroke(int width, Color color);
    void fill(Color color);
    void circle(int x, int y, int r);
    void ellipse(int x, int y, int rx, int ry);
    void line(int x1, int y1, int x2, int y2);
    void path(LineType type, int[] xs, int[] ys);
    void polygone(int[] xs, int[] ys);
    void polyline(int[] xs, int[] ys);
    void rectangle(int x, int y, int width, int height);
    void text(int x, int y, String text);

}
