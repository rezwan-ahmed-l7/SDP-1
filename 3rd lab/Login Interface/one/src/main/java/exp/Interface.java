package exp;

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

public class Interface extends Application {

    private Stage window;
    private Scene loginScene, welcomeScene;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Login UI");

        // Title
        Label titleLabel = new Label("Welcome");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        // Username Field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle(
                "-fx-pref-width: 250px; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 12px 15px; " +
                        "-fx-background-radius: 5px;");

        // Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle(
                "-fx-pref-width: 250px; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 12px 15px; " +
                        "-fx-background-radius: 5px;");

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-color: #3498db; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 12px 50px; " +
                        "-fx-background-radius: 5px;");
        loginButton.setMaxWidth(Double.MAX_VALUE);

        // Error Label (if login fails)
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px; -fx-padding: 5px 0;");

        // Login Button Action
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Please enter both username and password!");
            } else {
                errorLabel.setText("");
                showWelcomeScene(username);
            }
        });

        // Layout for Login Scene
        VBox loginLayout = new VBox(20);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(50));
        loginLayout.setStyle("-fx-background-color: #f0f4f8;");
        loginLayout.getChildren().addAll(
                titleLabel,
                usernameField,
                passwordField,
                loginButton,
                errorLabel);

        loginScene = new Scene(loginLayout, 400, 450);

        // Welcome Label
        Label welcomeLabel = new Label();
        welcomeLabel.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        // Subtitle
        Label subtitleLabel = new Label("You have successfully logged in!");
        subtitleLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #7f8c8d;");

        // Logout Button
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-color: #e74c3c; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 12px 50px; " +
                        "-fx-background-radius: 5px;");
        logoutButton.setMaxWidth(Double.MAX_VALUE);

        logoutButton.setOnAction(e -> {
            window.setScene(loginScene);
            usernameField.clear();
            passwordField.clear();
            errorLabel.setText("");
        });

        // Layout for Welcome Scene
        VBox welcomeLayout = new VBox(15);
        welcomeLayout.setAlignment(Pos.CENTER);
        welcomeLayout.setPadding(new Insets(50));
        welcomeLayout.setStyle("-fx-background-color: #f0f4f8;");
        welcomeLayout.getChildren().addAll(
                welcomeLabel,
                subtitleLabel,
                logoutButton);

        welcomeScene = new Scene(welcomeLayout, 400, 450);

        window.setScene(loginScene);
        window.show();
    }

    // Method to show Welcome Scene with username
    private void showWelcomeScene(String username) {
        Label welcomeLabel = (Label) ((VBox) welcomeScene.getRoot()).getChildren().get(0);
        welcomeLabel.setText("Hello, " + username + "!");
        window.setScene(welcomeScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}