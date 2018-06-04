package main.java;

import javafx.scene.image.Image;

public class Prop extends Actor {
    public Prop(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        spriteFrame.setTranslateX(xLocation);
        spriteFrame.setTranslateY(yLocation);
    }

    @Override
    public void update() {

    }
}
