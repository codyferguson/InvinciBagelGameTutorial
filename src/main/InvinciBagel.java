package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

import static javafx.stage.StageStyle.TRANSPARENT;

public class InvinciBagel extends Application {
    Scene scene;
    StackPane root;
    Image splashScreen, instructionLayer, legalLayer, screenLayer;
    ImageView slashScreenBackplate, splashScreenTextArea;
    Button gameButton, helpButton, scoreButton, legalButton;
    HBox buttonContainer;
    Insets buttonContainerPadding;

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
        createSplashScreenNodes();
        addNodesToStackPane();
        primaryStage.setTitle("InvinciBagel");
        primaryStage.setScene(scene);
        primaryStage.show();
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        legalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private void createSplashScreenNodes() {
        gameButton = new Button();
        gameButton.setText("game");
        helpButton = new Button();
        helpButton.setText("help");
        scoreButton = new Button();
        scoreButton.setText("score");
        legalButton = new Button();
        legalButton.setText("legal");

        root = new StackPane();
        root.setBackground(Background.EMPTY);
        scene = new Scene(root, 300, 275);
    }

    private void addNodesToStackPane() {
        root.getChildren().add(gameButton);
        root.getChildren().add(helpButton);
        root.getChildren().add(scoreButton);
        root.getChildren().add(legalButton);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
