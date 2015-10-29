package xml;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Rectangle;

public class RectangleXML implements ShapeState {

    /************************************
     *    Attributes
     ************************************/
    private Rectangle rectangle;

    /************************************
     *    Constructors
     ************************************/
    public RectangleXML(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /************************************
     *    Getters and Setters
     ************************************/
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setX(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /************************************
     *    Methods
     ************************************/
    @Override
    public String getDrawing(PencilState pencil) {
        return "<rect x=\""+this.getRectangle().getX()+"\" y=\""+this.getRectangle().getY()+"\" width=\""+this.getRectangle().getWidth()+"\" height=\""+this.getRectangle().getHeight()+"\" fill=\""+this.getRectangle().getColor()+"\" "+pencil.getDrawing()+" />";
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Rectangle){
            this.rectangle = (Rectangle) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }

    }
}
