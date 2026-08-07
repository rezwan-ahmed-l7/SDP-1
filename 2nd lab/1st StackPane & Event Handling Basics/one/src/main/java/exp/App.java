package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a button
        Button btn = new Button("Click Me");

        // Set event handler
        btn.setOnAction(e -> {
            System.out.println("Button was clicked!");
        });

        // Create a StackPane
        StackPane root = new StackPane();
        root.getChildren().add(btn); // Add the button

        // Create a scene
        Scene scene = new Scene(root, 400, 300);

        // Set the stage title
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}