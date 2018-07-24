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
    private boolean animator = false;
    private int frameCounter = 0;
    private int runningSpeed = 6;

    protected InvinciBagel invinciBagel;

    public Bagel(InvinciBagel iBagel, String SVGdata, double xLocation, double yLocation, Image... spriteCells) {
        super(SVGdata, xLocation, yLocation, spriteCells);
        invinciBagel = iBagel;
    }

    @Override
    public void update() {
        setXYLocation();
        setBoundaries();
        setImageState();
        moveInvinciBagel(iX, iY);
        playAudioClip();
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

    private void playAudioClip() {
        if(invinciBagel.isLeft())
            invinciBagel.playiSound0();
        if(invinciBagel.isRight())
            invinciBagel.playiSound1();
        if(invinciBagel.isUp())
            invinciBagel.playiSound2();
        if(invinciBagel.isDown())
            invinciBagel.playiSound3();
        if(invinciBagel.iswKey())
            invinciBagel.playiSound4();
        if(invinciBagel.issKey())
            invinciBagel.playiSound5();
    }

    private void setImageState(){
        if(!invinciBagel.isRight() && !invinciBagel.isLeft() && !invinciBagel.isDown() && !invinciBagel.isUp()){
            spriteFrame.setImage(imageStates.get(0));
            animator = false;
            frameCounter = 0;
        }
        if(invinciBagel.isRight()){
            spriteFrame.setScaleX(1);
            this.setIsFlipH(false);
            if(!animator && (!invinciBagel.isDown() && ! invinciBagel.isUp())){
                spriteFrame.setImage(imageStates.get(1));
                if(frameCounter >= runningSpeed) {
                    animator = true;
                    frameCounter = 0;
                } else
                    frameCounter++;
            } else if(animator){
                spriteFrame.setImage(imageStates.get(2));
                if(frameCounter >= runningSpeed){
                    animator = false;
                    frameCounter = 0;
                } else
                    frameCounter++;
            }
        }
        if(invinciBagel.isLeft()){
            spriteFrame.setScaleX(-1);
            this.setIsFlipH(true);
            if(!animator && (!invinciBagel.isDown() && !invinciBagel.isUp())) {
                spriteFrame.setImage(imageStates.get(1));
                if(frameCounter >= runningSpeed) {
                    animator = true;
                    frameCounter = 0;
                } else
                    frameCounter++;
            } else if (animator){
                spriteFrame.setImage(imageStates.get(2));
                if(frameCounter >= runningSpeed) {
                    animator = false;
                    frameCounter = 0;
                } else
                    frameCounter++;
            }
        }
        if(invinciBagel.isDown()){
            spriteFrame.setImage(imageStates.get(6));
        }
        if(invinciBagel.isUp()) {
            spriteFrame.setImage(imageStates.get(4));
        }
        if(invinciBagel.iswKey()){
            spriteFrame.setImage(imageStates.get(5));
        }
        if(invinciBagel.issKey()){
            spriteFrame.setImage(imageStates.get(8));
        }
    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
