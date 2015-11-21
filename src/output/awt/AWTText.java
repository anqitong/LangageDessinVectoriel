package output.awt;

import model.Shape;
import model.specific_path.Text;

import org.junit.Test;

import output.ShapeState;

import java.awt.*;

/**
 * Created by Xiaxing SHI on 11/11/15.
 */
public class AWTText implements ShapeState {
    private Text text;
    private StateDelegate delegate;

    public AWTText(Text text, StateDelegate delegate) {
        this.text = text;
        this.delegate = delegate;
    }

    @Override
    public Object getDrawing() {
        Graphics2D g = delegate.getGraphics2D();

        g.setColor(this.text.getPencil().getColor());
        g.setStroke(new BasicStroke(this.text.getPencil().getWidth()));
        g.drawString(this.text.getText(), this.text.getX(), this.text.getY());

        return this;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Text){
            this.text = (Text) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }
    }
}
