package main.java;

import static main.java.InvinciBagel.down;
import static main.java.InvinciBagel.left;
import static main.java.InvinciBagel.right;
import static main.java.InvinciBagel.up;
import javafx.scene.image.Image;

public class Bagel extends Hero {

    public Bagel(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
    }

    @Override
    public void update() {
        if(right)
            iX += vX;
        if(left)
            iX -= vX;
        if(down)
            iY += vY;
        if(up)
            iY -= vY;
        spriteFrame.setTranslateX(iX);
        spriteFrame.setTranslateY(iY);
    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
