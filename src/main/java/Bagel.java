package main.java;

import javafx.scene.image.Image;
import static main.java.InvinciBagel.WIDTH;
import static main.java.InvinciBagel.HEIGHT;

public class Bagel extends Hero {
    protected static final double SPRITE_PIXELS_X = 81;
    protected static final double SPRITE_PIXELS_Y = 81;
    protected static final double rightBoundary = WIDTH/2 - SPRITE_PIXELS_X/2;
    protected static final double leftBoundary = -(WIDTH/2 - SPRITE_PIXELS_X/2);
    protected static final double bottomBoundary = HEIGHT/2 - SPRITE_PIXELS_Y/2;
    protected static final double topBoundary = -(HEIGHT/2 - SPRITE_PIXELS_Y/2);

    protected InvinciBagel invinciBagel;

    public Bagel(InvinciBagel iBagel, String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        invinciBagel = iBagel;
    }

    @Override
    public void update() {
        setXYLocation();
        setBoundaries();
        moveInvinciBagel(iX, iY);
    }

    private void setXYLocation() {
        if(invinciBagel.isRight())
            iX += vX;
        if(invinciBagel.isLeft())
            iX -= vX;
        if(invinciBagel.isDown())
            iY += vY;
        if(invinciBagel.isUp())
            iY -= vY;
    }

    private void setBoundaries() {
        if(iX >= rightBoundary)
            iX = rightBoundary;
        if(iX <= leftBoundary)
            iX = leftBoundary;
        if(iY >= bottomBoundary)
            iY = bottomBoundary;
        if(iY <= topBoundary)
            iY = topBoundary;
    }

    private void moveInvinciBagel(double x, double y) {
        spriteFrame.setTranslateX(x);
        spriteFrame.setTranslateY(y);
    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
