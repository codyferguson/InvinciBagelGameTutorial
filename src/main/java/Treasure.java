package main.java;

import javafx.scene.image.Image;

public class Treasure extends Actor {

    public Treasure(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        spriteFrame.setTranslateX(xLocation);
        spriteFrame.setTranslateY(yLocation);
        hasValu = true;
        isBonus = true;
    }

    @Override
    public void update() {

    }
}
