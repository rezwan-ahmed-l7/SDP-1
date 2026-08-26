package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create Label
        Label label = new Label("Welcome!");

        // Create Buttons
        Button btn1 = new Button("Click Me");
        Button btn2 = new Button("Press Me");

        // Event Handling
        btn1.setOnAction(e -> label.setText("Hello!")); // change label text
        btn2.setOnAction(e -> label.setText("Goodbye!")); // change label text

        // Layout
        VBox root = new VBox(10); // 10 px spacing
        root.getChildren().addAll(label, btn1, btn2);

        // Scene
        Scene scene = new Scene(root, 400, 300);

        // Stage
        primaryStage.setTitle("Interactive Label Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}