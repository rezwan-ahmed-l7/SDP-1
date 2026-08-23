package exp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class login extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("Welcome");

        Label welcomeLabel = new Label("Hello, User!");
        Label subtitleLabel = new Label("You have successfully logged in!");

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            welcomeLabel.setText("Logged out");
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(welcomeLabel, subtitleLabel, logoutButton);

        window.setScene(new Scene(layout, 350, 300));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}