package main.java;

import javafx.scene.image.Image;

public abstract class Hero extends Actor {
    protected double vX, vY, lifeSpan, damage, offsetX, offsetY;
    protected float boundScale, boundRot, friction, gravity, bounce;

    public Hero(String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        lifeSpan = 1000;
        vX = vY = damage = offsetX = offsetY = 0;
        boundScale = boundRot = friction = gravity = bounce = 0;
    }

    @Override public abstract void update();

    public boolean collide(Actor object){
        return false;
    }
    public double getvX() {
        return vX;
    }
    public double getvY() {
        return vY;
    }
    public double getLifeSpan() {
        return lifeSpan;
    }
    public double getDamage() {
        return damage;
    }
    public double getOffsetX() {
        return offsetX;
    }
    public double getOffsetY() {
        return offsetY;
    }
    public float getBoundScale() {
        return boundScale;
    }
    public float getBoundRot() {
        return boundRot;
    }
    public float getFriction() {
        return friction;
    }
    public float getGravity() {
        return gravity;
    }
    public float getBounce() {
        return bounce;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }
    public void setvY(double vY) {
        this.vY = vY;
    }
    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }
    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }
    public void setBoundScale(float boundScale) {
        this.boundScale = boundScale;
    }
    public void setBoundRot(float boundRot) {
        this.boundRot = boundRot;
    }
    public void setFriction(float friction) {
        this.friction = friction;
    }
    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
    public void setBounce(float bounce) {
        this.bounce = bounce;
    }
}
