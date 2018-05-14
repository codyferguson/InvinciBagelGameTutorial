package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InvinciBagel extends Application {

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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
