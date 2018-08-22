package main.java;

import javafx.scene.image.Image;

import java.util.Random;

public class Enemy extends Actor {
    protected static final Random randomNum = new Random();
    int attackCounter = 0;
    int attackFrequency = 250;
    boolean takeSides = false;
    int attackBoundary = 300;
    boolean onScreen = false;
    boolean callAttack = false;
    boolean shootBullet = false;
    int spriteMoveR, spriteMoveL, destination, randomLocation, randomOffset, bulletRange, bulletOffset;
    InvinciBagel invinciBagel;
    int pauseCounter = 0;
    boolean launchIt = false;

    public Enemy(InvinciBagel iBagel, String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        invinciBagel = iBagel;
        spriteFrame.setTranslateX(xLocation);
        spriteFrame.setTranslateY(yLocation);
        isAlive = true;
        isBonus = true;
        hasValu = true;
    }

    @Override
    public void update() {
        if (!callAttack){
            if(attackCounter >= attackFrequency){
                attackCounter = 0;
                spriteMoveR = 700;
                spriteMoveL = -70;
                randomLocation = randomNum.nextInt(attackBoundary);
                spriteFrame.setTranslateY(randomLocation);
                randomOffset = randomLocation + 5;
                callAttack = true;
            } else { attackCounter++; }
        } else { initiateAttack(); }
        if (shootBullet){
            shootProjectile();
            if(pauseCounter >= 60) {
                launchIt = true;
                pauseCounter = 0;
            } else {
                pauseCounter++;
            }
        }
    }

    private void initiateAttack() {
        if(!takeSides){
            spriteFrame.setScaleX(1);
            this.setIsFlipH(false);
            if(!onScreen) {
                destination = 500;
                if(spriteMoveR >= destination) {
                    spriteMoveR -= 2;
                    spriteFrame.setTranslateX(spriteMoveR);
                } else {
                    bulletOffset = 480;
                    shootBullet = true;
                    onScreen = true;
                }
            }
            if (onScreen && launchIt) {
                destination = 700;
                if(spriteMoveR <= destination) {
                    spriteMoveR += 1;
                    spriteFrame.setTranslateX(spriteMoveR);
                } else {
                    onScreen = false;
                    takeSides = true;
                    callAttack = false;
                    launchIt = false;
                }
            }
        }
        if (takeSides){
            spriteFrame.setScaleX(-1);
            this.setIsFlipH(true);
            if(!onScreen){
                destination = 100;
                if(spriteMoveL <= destination) {
                    spriteMoveL += 2;
                    spriteFrame.setTranslateX(spriteMoveL);
                } else {
                    bulletOffset = 120;
                    shootBullet = true;
                    onScreen = true;
                }
            }
            if (onScreen) {
                destination = -70;
                if(spriteMoveL >= destination) {
                    spriteMoveL -= 1;
                    spriteFrame.setTranslateX(spriteMoveL);
                } else {
                    onScreen = false;
                    takeSides = false;
                    callAttack = false;
                }
            }
            spriteFrame.setTranslateX(100);
            takeSides = true;
        }
    }

    private void shootProjectile() {
        if(!takeSides){
            invinciBagel.iBullet.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iBullet.spriteFrame.setScaleX(-0.5);
            invinciBagel.iBullet.spriteFrame.setScaleY(0.5);
            bulletRange = -50;
            if(bulletOffset >= bulletRange){
                bulletOffset -= 4;
                invinciBagel.iBullet.spriteFrame.setTranslateX(bulletOffset);
            } else {
                shootBullet = true;
            }
        }
        if(takeSides) {
            invinciBagel.iBullet.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iBullet.spriteFrame.setScaleX(0.5);
            invinciBagel.iBullet.spriteFrame.setScaleY(0.5);
            bulletRange = 624;
            if(bulletOffset <= bulletRange) {
                bulletOffset += 4;
                invinciBagel.iBullet.spriteFrame.setTranslateX(bulletOffset);
            } else {
                shootBullet = false;
            }
        }
    }
}
