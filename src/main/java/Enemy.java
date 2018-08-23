package main.java;

import javafx.scene.image.Image;

import java.util.Random;

public class Enemy extends Actor {
    protected static final Random randomNum = new Random();
    private int attackCounter = 0;
    private int attackFrequency = 250;
    private boolean takeSides = false;
    private int attackBoundary = 300;
    private boolean onScreen = false;
    private boolean callAttack = false;
    private boolean shootBullet = false;
    private int spriteMoveR, spriteMoveL, destination, randomLocation, bulletRange, bulletOffset;
    private double randomOffset, bulletGravity = 0.2, cheeseGravity = 0.1;
    private InvinciBagel invinciBagel;
    private int pauseCounter = 0;
    private boolean launchIt = false;
    private boolean bulletType = false;
    private int iBagelLocation;

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
                iBagelLocation = (int)invinciBagel.iBagel.getiY();
                bulletType = randomNum.nextBoolean();
                if (bulletType) {
                    spriteFrame.setTranslateY(randomLocation);
                    randomOffset = randomLocation + 5;
                } else {
                    spriteFrame.setTranslateY(iBagelLocation);
                    randomOffset = iBagelLocation + 5;
                }
                takeSides = randomNum.nextBoolean();
                callAttack = true;
            } else {
                attackCounter++;
            }
        } else {
            initiateAttack();
        }
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
                    callAttack = false;
                    launchIt = false;
                    loadBullet();
                    loadCheese();
                    loadEnemy();
                    attackFrequency = 60 + randomNum.nextInt(480);
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
            if (onScreen && launchIt) {
                destination = -70;
                if(spriteMoveL >= destination) {
                    spriteMoveL -= 1;
                    spriteFrame.setTranslateX(spriteMoveL);
                } else {
                    onScreen = false;
                    callAttack = false;
                    launchIt = false;
                    loadBullet();
                    loadCheese();
                    loadEnemy();
                    attackFrequency = 60 + randomNum.nextInt(480);
                }
            }
        }
    }

    private void shootProjectile() {
        if(!bulletType && !takeSides){
            invinciBagel.iBullet.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iBullet.spriteFrame.setScaleX(-0.5);
            invinciBagel.iBullet.spriteFrame.setScaleY(0.5);
            bulletRange = -50;
            if(bulletOffset >= bulletRange){
                bulletOffset -= 6;
                invinciBagel.iBullet.spriteFrame.setTranslateX(bulletOffset);
                randomOffset += bulletGravity;
            } else {
                shootBullet = false;
            }
        }
        if(!bulletType && takeSides) {
            invinciBagel.iBullet.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iBullet.spriteFrame.setScaleX(0.5);
            invinciBagel.iBullet.spriteFrame.setScaleY(0.5);
            bulletRange = 624;
            if(bulletOffset <= bulletRange) {
                bulletOffset += 6;
                invinciBagel.iBullet.spriteFrame.setTranslateX(bulletOffset);
                randomOffset += bulletGravity;
            } else {
                shootBullet = false;
            }
        }
        if(bulletType && !takeSides){
            invinciBagel.iCheese.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iCheese.spriteFrame.setScaleX(-0.5);
            invinciBagel.iCheese.spriteFrame.setScaleY(0.5);
            bulletRange = -50;
            if(bulletOffset >= bulletRange){
                bulletOffset -= 4;
                invinciBagel.iCheese.spriteFrame.setTranslateX(bulletOffset);
                randomOffset += cheeseGravity;
            } else {
                shootBullet = false;
            }
        }
        if(bulletType && takeSides) {
            invinciBagel.iCheese.spriteFrame.setTranslateY(randomOffset);
            invinciBagel.iCheese.spriteFrame.setScaleX(0.5);
            invinciBagel.iCheese.spriteFrame.setScaleY(0.5);
            bulletRange = 624;
            if(bulletOffset <= bulletRange) {
                bulletOffset += 4;
                invinciBagel.iCheese.spriteFrame.setTranslateX(bulletOffset);
                randomOffset += cheeseGravity;
            } else {
                shootBullet = false;
            }
        }
    }

    private void loadBullet() {
        for (int i = 0; i < invinciBagel.castDirector.getCurrentCast().size(); i++) {
            Actor object = invinciBagel.castDirector.getCurrentCast().get(i);
            if(object.equals(invinciBagel.iBullet)) { return; }
        }
        invinciBagel.castDirector.addCurrentCast(invinciBagel.iBullet);
        invinciBagel.root.getChildren().add(invinciBagel.iBullet.spriteFrame);
    }

    private void loadCheese() {
        for (int i = 0; i < invinciBagel.castDirector.getCurrentCast().size(); i++) {
            Actor object = invinciBagel.castDirector.getCurrentCast().get(i);
            if(object.equals(invinciBagel.iCheese)) { return; }
        }
        invinciBagel.castDirector.addCurrentCast(invinciBagel.iCheese);
        invinciBagel.root.getChildren().add(invinciBagel.iCheese.spriteFrame);
    }

    private void loadEnemy() {
        for (int i = 0; i < invinciBagel.castDirector.getCurrentCast().size(); i++) {
            Actor object = invinciBagel.castDirector.getCurrentCast().get(i);
            if(object.equals(invinciBagel.iBeagle)) { return; }
        }
        invinciBagel.castDirector.addCurrentCast(invinciBagel.iBeagle);
        invinciBagel.root.getChildren().add(invinciBagel.iBeagle.spriteFrame);
    }
}
