package main.java;

import javafx.scene.image.Image;

public class PropB extends Actor {
    public PropB(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        this.setIsFlipH(true);
        this.setIsFlipV(true);
        spriteFrame.setScaleX(-1);
        spriteFrame.setScaleY(-1);
        spriteFrame.setTranslateX(xLocation);
        spriteFrame.setTranslateY(yLocation);
    }

    @Override
    public void update() {

    }
}
