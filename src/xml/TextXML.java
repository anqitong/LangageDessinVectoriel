package xml;

import view.PencilState;
import view.ShapeState;
import model.Shape;
import model.specific_path.Text;

public class TextXML implements ShapeState {

    /************************************
     *    Attributes
     ************************************/
    private Text text;

    /************************************
     *    Constructors
     ************************************/
    public TextXML(Text text) {
        this.text = text;
    }

    /************************************
     *    Getters and Setters
     ************************************/
    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    /************************************
     *    Methods
     ************************************/
    @Override
    public String getDrawing(PencilState pencil) {
        return "<text x=\""+this.getText().getX()+"\" y=\""+this.getText().getY()+"\" "+pencil.getDrawing()+"\">"+this.getText().getText()+"</text>";
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
