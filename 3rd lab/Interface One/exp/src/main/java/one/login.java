package one;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class login extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Login");

        Label titleLabel = new Label("Welcome");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        Label errorLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Please enter both username and password!");
            } else {
                errorLabel.setText("Login successful! (Username: " + username + ")");
            }
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, errorLabel);

        window.setScene(new Scene(layout, 350, 300));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}