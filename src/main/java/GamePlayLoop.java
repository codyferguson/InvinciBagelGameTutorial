package main.java;

import javafx.animation.AnimationTimer;
import static main.java.InvinciBagel.iBagel; // did not know you could do this!

public class GamePlayLoop extends AnimationTimer {
    @Override
    public void handle(long now) {
        iBagel.update();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
