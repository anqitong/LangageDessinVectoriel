package model.presentation;

import model.ShapesName;

/**
 * Created by Xiaxing SHI on 27/10/15.
 */
public class Circle implements Shape {
    /************************************
     *	Attributes
     ************************************/
    private int center_x; // Where the center of the circle is (x axis)
    private int center_y; // Where the center of the circle is (y axis)
    private int radius; // The radius of the circle

    /************************************
     *	Constructors
     ************************************/
    public Circle(int center_x, int center_y, int radius) {
        this.center_x = center_x;
        this.center_y = center_y;
        this.radius = radius;
    }

    public Circle() {
        this.center_x = 0;
        this.center_y = 0;
        this.radius = 1;
    }

    /************************************
     *	Getters and Setters
     ************************************/

    public int getCenter_x() {
        return center_x;
    }

    public void setCenter_x(int center_x) {
        this.center_x = center_x;
    }

    public int getCenter_y() {
        return center_y;
    }

    public void setCenter_y(int center_y) {
        this.center_y = center_y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    /************************************
     *	Methods
     ************************************/

    @Override
    public ShapesName getName() {
        return ShapesName.Circle;
    }
}
