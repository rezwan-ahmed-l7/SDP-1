package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a label for the ComboBox
        Label locLabel = new Label("Location:");

        ComboBox<String> locationCombo = new ComboBox<>();

        locationCombo.getItems().addAll("Dhaka", "Saidpur", "Chittagong", "Rajshahi", "Khulna");

        locationCombo.setValue("Dhaka");

        locationCombo.setStyle("-fx-font-size: 14px; -fx-background-color: lightblue;");

        Button showButton = new Button("Show Selected Location");

        Label resultLabel = new Label();

        showButton.setOnAction(e -> {
            String selectedLocation = locationCombo.getValue();

            if (selectedLocation == null) {
                resultLabel.setText("Please select a location first");
            } else {
                resultLabel.setText("You selected: " + selectedLocation);
            }
        });

        // Create an HBox to hold the label and ComboBox
        HBox locBox = new HBox(10, locLabel, locationCombo);

        VBox root = new VBox(10, locBox, showButton, resultLabel);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Step 3: Using addAll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}