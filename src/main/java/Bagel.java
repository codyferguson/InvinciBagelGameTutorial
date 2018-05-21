package main.java;

import javafx.scene.image.Image;

public class Bagel extends Hero {

    public Bagel(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
