package xml;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Circle;

public class CircleXML implements ShapeState {

    /************************************
     *    Attributes
     ************************************/
    private Circle circle; // Shape used

    /************************************
     *    Constructors
     ************************************/
    public CircleXML(Circle circle) {
        this.circle = circle;
    }

    /************************************
     *    Getters and Setters
     ************************************/

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }


    /************************************
     *    Methods
     ************************************/
    @Override
    public String getDrawing(PencilState pencil) {
        return "<circle cx=\""+this.getCircle().getCenter_x()+"\" cy=\""+this.getCircle().getCenter_y()+"\" r=\""+this.getCircle().getRadius()+"\" fill=\""+this.getCircle().getColor()+"\" "+pencil.getDrawing()+" />";
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Circle){
            this.circle = (Circle) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }

    }

}
