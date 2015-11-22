package language;

import model.specific_path.LineType;
import java.awt.*;

/**
 * This defines what a user can do for drawing things
 */
public interface Painter {
    void setName(String name);
    void setCanvasSize(int width, int height);
    void setShowInWindow(boolean isWindow);
    void setSaveAsSVG(boolean isSvg);
    void stroke(int width, Color color);
    void fill(Color color);
    void circle(int x, int y, int r);
    void ellipse(int x, int y, int rx, int ry);
    void line(int x1, int y1, int x2, int y2);
    void path(LineType type, Point... points);
    void polygone(Point... points);
    void polyline(Point... points);
    void rectangle(int x, int y, int width, int height);
    void text(int x, int y, String text);
}
