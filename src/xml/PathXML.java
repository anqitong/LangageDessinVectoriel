package xml;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Path;

public class PathXML implements ShapeState {

    /************************************
     *    Attributes
     ************************************/
    private Path path;

    /************************************
     *    Constructors
     ************************************/
    public PathXML(Path path) {
        this.path = path;
    }

    /************************************
     *    Getters and Setters
     ************************************/
    public Path getPath() {
        return path;
    }

    public void setLine(Path path) {
        this.path = path;
    }


    /************************************
     *    Methods
     ************************************/
    @Override
    public String getDrawing(PencilState pencil) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setShape(Shape shape) throws Exception {
        if(shape instanceof Path){
            this.path = (Path) shape;
        }
        else{
            throw new Exception("The shape is not of the right type");
        }

    }

}
