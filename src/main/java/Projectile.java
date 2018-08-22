package main.java;

import javafx.scene.image.Image;

public class Projectile extends Actor {

    public Projectile(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        spriteFrame.setTranslateX(xLocation);
        spriteFrame.setTranslateY(yLocation);
        isFixed = false;
        isBonus = true;
        hasValu = true;
    }

    @Override
    public void update() {

    }
}
