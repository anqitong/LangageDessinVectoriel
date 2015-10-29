package xml;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Ellipse;

public class EllipseXML implements ShapeState {

    /************************************
     *    Attributes
     ************************************/
    private Ellipse ellipse; // Shape used

    /************************************
     *    Constructors
     ************************************/
    public EllipseXML(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    /************************************
     *    Getters and Setters
     ************************************/

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setCircle(Ellipse ellipse) {
        this.ellipse = ellipse;
    }


    /************************************
     *    Methods
     ************************************/
    @Override
    public String getDrawing(PencilState pencil) {
        return "<circle cx=\""+this.getEllipse().getCenter_x()+"\" cy=\""+this.getEllipse().getCenter_y()+"\" rx=\""+this.getEllipse().getRadius_x()+"\" ry=\""+this.getEllipse().getRadius_y()+"\" fill=\""+this.getEllipse().getColor()+"\" "+pencil.getDrawing()+" />";
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Ellipse){
            this.ellipse = (Ellipse) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }

    }

}
