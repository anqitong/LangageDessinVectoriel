package output.awt;

import model.Shape;
import model.specific_path.Line;

import java.awt.*;

import output.ShapeState;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class AWTLine implements ShapeState {
    private Line line;
    private StateDelegate delegate;

    public AWTLine(Line line, StateDelegate delegate) {
        this.line = line;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        g.setStroke(new BasicStroke(this.line.getPencil().getWidth()));
        g.drawLine(this.line.getX1(), this.line.getY1(), this.line.getX2(), this.line.getY2());

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Line){
            this.line = (Line) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }
    }
}
