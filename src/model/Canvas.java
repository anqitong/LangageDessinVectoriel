package model;

public class Canvas {

    /************************************
     *    Attributes
     ************************************/
    private int height;
    private int width;

    /************************************
     *    Constructor
     ************************************/
    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /************************************
     *    Getters and Setters
     ************************************/

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
