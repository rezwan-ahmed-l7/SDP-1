package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Label
        Label label = new Label("Welcome!");

        // Create TextField
        TextField textField = new TextField();
        textField.setPromptText("Type something here...");

        // Create Submit Button
        Button submitBtn = new Button("Submit");

        // Event Handling
        submitBtn.setOnAction(e -> {
            String userInput = textField.getText(); // get user input
            label.setText("User typed: " + userInput);
        });

        // Layout
        VBox root = new VBox(10); // 10 px spacing
        root.getChildren().addAll(label, textField, submitBtn);

        // Scene
        Scene scene = new Scene(root, 400, 300);

        // Stage
        primaryStage.setTitle("TextField Interaction Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}