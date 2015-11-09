package model.presentation.awt;

import model.Pencil;
import model.presentation.PencilState;

import java.awt.*;

/**
 * Created by Xiaxing SHI on 09/11/15.
 */
public class PencilAWT implements PencilState {

    private final Pencil p;
    private final Graphics2D g;

    public PencilAWT(Pencil p, Graphics2D g) {
        this.p = p;
        this.g = g;
    }
    @Override
    public Object getDrawing() {
        return g;
    }

    @Override
    public Pencil getPencil() {
        return p;
    }
}
