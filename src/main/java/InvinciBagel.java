package main.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InvinciBagel extends Application {
    private static final double WIDTH = 640, HEIGHT = 400;
    private boolean up, down, left, right;
    private static Bagel ibagel;
    private CastingDirector castDirector;
    private Scene scene;
    private StackPane root;
    private Image splashScreen, instructionLayer, legalLayer, scoresLayer;
    private Image iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8;
    private ImageView splashScreenBackplate, splashScreenTextArea;
    private Button gameButton, helpButton, scoreButton, legalButton;
    static HBox buttonContainer;
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
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("InvinciBagel");
        root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
        createSceneEventHandling();
        loadImageAssets();
        createGameActors();
        addGameActorNodes();
        createCastingDirection();
        createSplashScreenNodes();
        addNodesToStackPane();
        createStartGameLoop();
        gameButton.setOnAction(event -> {
            splashScreenBackplate.setVisible(false);
            splashScreenTextArea.setVisible(false);
        });
        helpButton.setOnAction(event -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(instructionLayer);
        });
        scoreButton.setOnAction(event -> {
                splashScreenBackplate.setVisible(true);
                splashScreenTextArea.setVisible(true);
                splashScreenTextArea.setImage(scoresLayer);
        });
        legalButton.setOnAction(event -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(legalLayer);
        });
        gamePlayLoop = new GamePlayLoop();
        gamePlayLoop.start();
    }

    private void createSceneEventHandling() {
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()){
                case UP:    up = true; break;
                case DOWN:  down = true; break;
                case LEFT:  left = true; break;
                case RIGHT: right = true; break;
                case W:     up = true; break;
                case S:     down = true; break;
                case A:     left = true; break;
                case D:     right = true; break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch(event.getCode()){
                case UP:    up = false; break;
                case DOWN:  down = false; break;
                case LEFT:  left = false; break;
                case RIGHT: right = false; break;
                case W:     up = false; break;
                case S:     down = false; break;
                case A:     left = false; break;
                case D:     right = false; break;
            }
        });
    }

    private void loadImageAssets() {
        splashScreen = new Image("/invincibagelsplash.png", 640, 400, true, false, true);
        instructionLayer = new Image("/invincibagelinstruct.png", 640, 400, true, false, true);
        legalLayer = new Image("/invincibagelcreds.png", 640, 400, true, false, true);
        scoresLayer = new Image("/invincibagelscores.png", 640, 400, true, false, true);
        iB0 = new Image("/sprite0.png", 81, 81, true, false, true);
        iB1 = new Image("/sprite1.png", 81, 81, true, false, true);
        iB2 = new Image("/sprite2.png", 81, 81, true, false, true);
        iB3 = new Image("/sprite3.png", 81, 81, true, false, true);
        iB4 = new Image("/sprite4.png", 81, 81, true, false, true);
        iB5 = new Image("/sprite5.png", 81, 81, true, false, true);
        iB6 = new Image("/sprite6.png", 81, 81, true, false, true);
        iB7 = new Image("/sprite7.png", 81, 81, true, false, true);
        iB8 = new Image("/sprite8.png", 81, 81, true, false, true);
    }

    private void createGameActors() {
        //Todo
    }

    private void createStartGameLoop() {
        //TODO
    }

    private void createCastingDirection() {
        //TODO
    }

    private void addGameActorNodes() {
        //TODO
    }



    private void createSplashScreenNodes() {
        root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);

        buttonContainer = new HBox(12);
        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);
        gameButton = new Button();
        gameButton.setText("PLAY GAME");
        helpButton = new Button();
        helpButton.setText("INSTRUCTIONS");
        scoreButton = new Button();
        scoreButton.setText("HIGH SCORES");
        legalButton = new Button();
        legalButton.setText("LEGAL & CREDITS");
        buttonContainer.getChildren().addAll(gameButton, helpButton, scoreButton, legalButton);
        splashScreenBackplate = new ImageView();
        splashScreenBackplate.setImage(splashScreen); // this java statement connects the two statements
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayer);
    }

    private void addNodesToStackPane() {
        root.getChildren().add(splashScreenBackplate);
        root.getChildren().add(splashScreenTextArea);
        root.getChildren().add(buttonContainer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
