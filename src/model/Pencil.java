package model;

/**
 * This is the type: "Crayon"
 */
public class Pencil {

    private int width;
    private ColorSVG color;

    public Pencil(int width, ColorSVG color) {
        super();
        this.width = width;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ColorSVG getColor() {
        return color;
    }

    public void setColor(ColorSVG color) {
        this.color = color;
    }

    public String getXML(){
        return "stroke=\""+this.getColor()+"\" stroke-width=\""+this.getWidth()+"\"";
    }

}
