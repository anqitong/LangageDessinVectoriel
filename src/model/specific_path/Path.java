package model.specific_path;

import model.Shape;
import model.ShapeName;

public class Path extends Shape {


    @Override
    public ShapeName getName() {
        return ShapeName.Path;
    }
}
