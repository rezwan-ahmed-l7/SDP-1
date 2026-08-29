package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button submitButton = new Button("Submit");
        Label resultLabel = new Label();

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            resultLabel.setText("Hello " + name);
        });

        VBox root = new VBox(10, nameLabel, nameField, submitButton, resultLabel);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}