package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label message = new Label("Welcome to Registration Form");
        StackPane root = new StackPane(message);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("JavaFX App Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}