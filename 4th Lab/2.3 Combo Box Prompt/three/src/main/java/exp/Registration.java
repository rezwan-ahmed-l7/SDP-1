package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        ComboBox<String> locationCombo = new ComboBox<>();

        locationCombo.getItems().addAll("Dhaka", "Saidpur", "Chittagong", "Rajshahi", "Khulna");

        locationCombo.setPromptText("Select your city"); // Set prompt text for the ComboBox

        VBox root = new VBox(10, locationCombo);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Step 3: Using addAll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}