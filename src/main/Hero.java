package main;

import javafx.scene.image.Image;

public abstract class Hero extends Actor {

    public Hero(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
    }
}
