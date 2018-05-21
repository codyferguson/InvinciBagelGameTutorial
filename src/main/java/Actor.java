package main.java;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Actor {
    protected List<Image> imageStates = new ArrayList<>();
    protected ImageView spriteFrame;
    protected SVGPath spriteBound;
    protected double iX;
    protected double iY;
    protected double pX;
    protected double pY;
    protected boolean isAlive;
    protected boolean isFixed;
    protected boolean isBonus;
    protected boolean hasValu;
    protected boolean isFlipV;
    protected boolean isFlipH;

    public Actor(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGdata);
        spriteFrame = new ImageView(spriteCells[0]);
        imageStates.addAll(Arrays.asList(spriteCells));
        iX = xLocation;
        iY = yLocation;
        pX = pY = 0;
        isAlive = isBonus = hasValu = isFlipV = isFlipH = false;
        isFixed = true;
    }

    public Actor(String SVGdata, double xLocation, double yLocation, double xPivot, double yPivot, Image... spriteCells) {
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGdata);
        spriteFrame = new ImageView(spriteCells[0]);
        imageStates.addAll(Arrays.asList(spriteCells));
        iX = xLocation;
        iY = yLocation;
    }

    public abstract void update();

    public List<Image> getImageStates() {
        return imageStates;
    }
    public ImageView getSpriteFrame() {
        return spriteFrame;
    }
    public SVGPath getSpriteBound() {
        return spriteBound;
    }
    public double getiX() {
        return iX;
    }
    public double getiY() {
        return iY;
    }
    public double getpX() {
        return pX;
    }
    public double getpY() {
        return pY;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public boolean isFixed() {
        return isFixed;
    }
    public boolean isBonus() {
        return isBonus;
    }
    public boolean HasValu() {
        return hasValu;
    }
    public boolean isFlipV() {
        return isFlipV;
    }
    public boolean isFlipH() {
        return isFlipH;
    }

    public void setImageStates(List<Image> imageStates) {
        this.imageStates = imageStates;
    }
    public void setSpriteFrame(ImageView spriteFrame) {
        this.spriteFrame = spriteFrame;
    }
    public void setSpriteBound(SVGPath spriteBound) {
        this.spriteBound = spriteBound;
    }
    public void setiX(double iX) {
        this.iX = iX;
    }
    public void setiY(double iY) {
        this.iY = iY;
    }
    public void setpX(double pX) {
        this.pX = pX;
    }
    public void setpY(double pY) {
        this.pY = pY;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }
    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }
    public void setHasValu(boolean hasValu) {
        this.hasValu = hasValu;
    }
    public void setFlipV(boolean flipV) {
        isFlipV = flipV;
    }
    public void setFlipH(boolean flipH) {
        isFlipH = flipH;
    }
}
