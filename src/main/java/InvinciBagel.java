package main.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.Group;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class InvinciBagel extends Application {
    protected static final double WIDTH = 640, HEIGHT = 400;
    Treasure iTR0, iTR1;
    Enemy iBeagle;
    Projectile iBullet, iCheese;
    int gameScore = 0;
    Text scoreText, scoreLabel;
    private Font scoreFont;
    private boolean up, down, left, right, wKey, sKey, aKey, dKey;
    Bagel iBagel;
    CastingDirector castDirector;
    private Scene scene;
    Group root;
    private Image splashScreen, instructionLayer, legalLayer, scoresLayer, skyCloud;
    private AudioClip iSound0, iSound1, iSound2, iSound3, iSound4, iSound5;
    private URL iAudioFile0, iAudioFile1, iAudioFile2, iAudioFile3, iAudioFile4, iAudioFile5;
    Prop iPR0, iPR1;
    PropH iPH0;
    PropV iPV0, iPV1;
    PropB iPB0;
    private Image iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8, iP0, iP1, iT0, iT1, iE0, iC0, iC1;
    private ImageView splashScreenBackplate, splashScreenTextArea;
    private Button gameButton, helpButton, scoreButton, legalButton;
    private HBox buttonContainer;
    private Insets buttonContainerPadding;
    private GamePlayLoop gamePlayLoop;

    public InvinciBagel() {
        int lifeIndex = 1000;
        int hitsIndex = 0;
        String directionFacing = "E";
        Boolean currentlyMoving = false;
    }

    public InvinciBagel(int lifespan, String direction) {
        int lifeIndex;
        int hitsIndex;
        String directionFacing = null;
        Boolean currentlyMoving = false;
        lifeIndex = lifespan;
        directionFacing = direction;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("InvinciBagel");
        root = new Group();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
        createSceneEventHandling();
        loadAudioAssets();
        loadImageAssets();
        createGameActors();
        addGameActorNodes();
        createCastingDirection();
        createSplashScreenNodes();
        addNodesToStackPane();
        createStartGameLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createSceneEventHandling() {
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()){
                case UP:    up = true; break;
                case DOWN:  down = true; break;
                case LEFT:  left = true; break;
                case RIGHT: right = true; break;
                case W:     wKey = true; break;
                case S:     sKey = true; break;
                case A:     aKey = true; break;
                case D:     dKey = true; break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch(event.getCode()){
                case UP:    up = false; break;
                case DOWN:  down = false; break;
                case LEFT:  left = false; break;
                case RIGHT: right = false; break;
                case W:     wKey = false; break;
                case S:     sKey = false; break;
                case A:     aKey = false; break;
                case D:     dKey = false; break;
            }
        });
    }

    private void loadAudioAssets() {
        // so you don't have to do absolute file loc
        iAudioFile0 = getClass().getResource("/leftmono.wav");
        iSound0 = new AudioClip(iAudioFile0.toString());
        iAudioFile1 = getClass().getResource("/rightmono.wav");
        iSound1 = new AudioClip(iAudioFile1.toString());
        iAudioFile2 = getClass().getResource("/upmono.wav");
        iSound2 = new AudioClip(iAudioFile2.toString());
        iAudioFile3 = getClass().getResource("/downmono.wav");
        iSound3 = new AudioClip(iAudioFile3.toString());
        iAudioFile4 = getClass().getResource("/wmono.wav");
        iSound4 = new AudioClip(iAudioFile4.toString());
        iAudioFile5 = getClass().getResource("/smono.wav");
        iSound5 = new AudioClip(iAudioFile5.toString());
    }

    private void loadImageAssets() {
        splashScreen = new Image("/invincibagelsplash.png", 640, 400, true, false, true);
        instructionLayer = new Image("/invincibagelinstruct.png", 640, 400, true, false, true);
        legalLayer = new Image("/invincibagelcreds.png", 640, 400, true, false, true);
        scoresLayer = new Image("/invincibagelscores.png", 640, 400, true, false, true);
        skyCloud = new Image("/skycloud.png", 640, 400, true, false, true);
        iB0 = new Image("/sprite0.png", 81, 81, true, false, true);
        iB1 = new Image("/sprite1.png", 81, 81, true, false, true);
        iB2 = new Image("/sprite2.png", 81, 81, true, false, true);
        iB3 = new Image("/sprite3.png", 81, 81, true, false, true);
        iB4 = new Image("/sprite4.png", 81, 81, true, false, true);
        iB5 = new Image("/sprite5.png", 81, 81, true, false, true);
        iB6 = new Image("/sprite6.png", 81, 81, true, false, true);
        iB7 = new Image("/sprite7.png", 81, 81, true, false, true);
        iB8 = new Image("/sprite8.png", 81, 81, true, false, true);
        iP0 = new Image("/prop0.png", 72, 32, true, false, true);
        iP1 = new Image("/prop1.png", 496, 92, true, false, true);
        iT0 = new Image("/treasure1.png", 64, 64, true, false, true);
        iT1 = new Image("/treasure2.png", 64, 64, true, false, true);
        iE0 = new Image("/enemy.png", 70 , 116, true, false, true);
        iC0 = new Image("/bullet.png", 64, 24, true, false, true);
        iC1 = new Image("/cheese.png", 32, 29, true, false, true);
    }

    private void createGameActors() {
        //TODO Add data here! ---------------------- v --------
        iBagel = new Bagel(this,
                "M150 0 L75 500 L225 200 Z",
                WIDTH/2, HEIGHT/2, iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8);
        iPR0 = new Prop("M0,0 L0,32 72,32 72,0 Z", 30, 48, iP0);
        iPH0 = new PropH("M0,0 L0,32 72,32 72,0 Z", 172, 248, iP0);
        iPV0 = new PropV("M0,0 L0,32 72,32 72,0 Z", 396, 116, iP0);
        iPB0 = new PropB("M0,0 L0,32 72,32 72,0 Z", 512, 316, iP0);
        iTR0 = new Treasure("M0 0 L0 64 64 64 64 0 Z", 50, 105, iT0);
        iTR1 = new Treasure("M0 0 L0 64 64 64 64 0 Z", 533, 206, iT1);
        iBeagle = new Enemy(this, "", 520, 160, iE0);
        iBullet = new Projectile("", 8, 8, iC0);
        iCheese = new Projectile("", 96, 8, iC1);
        //iPR1 = new Prop("M0 0 L0 32 72 32 72 0 Z", 72, 148, iP1);
        //iPV1 = new PropV("M150 0 L75 200 L225 200 Z", 0, -58, iP1);

    }

    private void addGameActorNodes() {
        root.getChildren().add(iPR0.spriteFrame);
//        root.getChildren().add(iPR1.spriteFrame);
        root.getChildren().add(iPH0.spriteFrame);
        root.getChildren().add(iPV0.spriteFrame);
//        root.getChildren().add(iPV1.spriteFrame);
        root.getChildren().add(iPB0.spriteFrame);
        root.getChildren().add(iBagel.spriteFrame);
        root.getChildren().add(iTR0.spriteFrame);
        root.getChildren().add(iTR1.spriteFrame);
        root.getChildren().add(iBeagle.spriteFrame);
        root.getChildren().add(iBullet.spriteFrame);
        root.getChildren().add(iCheese.spriteFrame);

    }

    private void createCastingDirection() {
        castDirector = new CastingDirector();
        castDirector.addCurrentCast(iPR0, iPH0, iPV0, iPB0, iTR0, iTR1, iBeagle, iBullet, iCheese);
    }

    private void createSplashScreenNodes() {
        scoreText = new Text();
        scoreText.setText(String.valueOf(gameScore));
        scoreText.setLayoutY(385);
        scoreText.setLayoutX(620);
        scoreFont = new Font("Verdana", 20);
        scoreText.setFont(scoreFont);
        scoreText.setFill(Color.BLUE);
        scoreLabel = new Text();
        scoreLabel.setText("SCORE:");
        scoreLabel.setLayoutY(385);
        scoreLabel.setLayoutX(540);
        scoreLabel.setFont(scoreFont);
        scoreLabel.setFill(Color.BLACK);
        buttonContainer = new HBox(12);
        buttonContainer.setLayoutY(365);
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);
        gameButton = new Button();
        gameButton.setText("PLAY GAME");
        gameButton.setOnAction(event -> {
            splashScreenBackplate.setImage(skyCloud);
            splashScreenBackplate.setVisible(true);
            splashScreenBackplate.toBack();
            splashScreenTextArea.setVisible(false);
        });
        helpButton = new Button();
        helpButton.setText("INSTRUCTIONS");
        helpButton.setOnAction(event -> {
            setScreen(instructionLayer);
        });
        scoreButton = new Button();
        scoreButton.setText("HIGH SCORES");
        scoreButton.setOnAction(event -> {
            setScreen(scoresLayer);
        });
        legalButton = new Button();
        legalButton.setText("LEGAL & CREDITS");
        legalButton.setOnAction(event -> {
            setScreen(legalLayer);
        });
        buttonContainer.getChildren().addAll(gameButton, helpButton, scoreButton, legalButton);
        splashScreenBackplate = new ImageView();
        splashScreenBackplate.setImage(splashScreen); // this java statement connects the two statements
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayer);
    }

    private void setScreen(Image image) {
        splashScreenBackplate.setImage(splashScreen);
        splashScreenBackplate.toFront();
        splashScreenBackplate.setVisible(true);
        splashScreenTextArea.setVisible(true);
        splashScreenTextArea.setImage(image);
        splashScreenTextArea.toFront();
        buttonContainer.toFront();
    }

    private void createStartGameLoop() {
        gamePlayLoop = new GamePlayLoop(this);
        gamePlayLoop.start();
    }

    private void addNodesToStackPane() {
        root.getChildren().add(splashScreenBackplate);
        root.getChildren().add(splashScreenTextArea);
        root.getChildren().add(buttonContainer);
        root.getChildren().add(scoreText);
        root.getChildren().add(scoreLabel);
    }

    public boolean isUp() {
        return up;
    }
    public boolean isDown() {
        return down;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isRight() {
        return right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean iswKey() {
        return wKey;
    }
    public boolean issKey() {
        return sKey;
    }
    public boolean isaKey() {
        return aKey;
    }
    public boolean isdKey() {
        return dKey;
    }

    public void setwKey(boolean wKey) {
        this.wKey = wKey;
    }
    public void setsKey(boolean sKey) {
        this.sKey = sKey;
    }
    public void setaKey(boolean aKey) {
        this.aKey = aKey;
    }
    public void setdKey(boolean dKey) {
        this.dKey = dKey;
    }

    public void playiSound0() {
        this.iSound0.play();
    }
    public void playiSound1() {
        this.iSound1.play();
    }
    public void playiSound2() {
        this.iSound2.play();
    }
    public void playiSound3() {
        this.iSound3.play();
    }
    public void playiSound4() {
        this.iSound4.play();
    }
    public void playiSound5() {
        this.iSound5.play();
    }
}
