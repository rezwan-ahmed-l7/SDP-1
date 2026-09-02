package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        ComboBox<String> locationCombo = new ComboBox<>();

        locationCombo.getItems().addAll("Dhaka", "Saidpur", "Chittagong", "Rajshahi", "Khulna");

        locationCombo.setValue("Dhaka"); // Set default value

        Button showButton = new Button("Show Selected Location"); // Create a button to show the selected location

        Label resultLabel = new Label(); // Create a label to display the result

        // Add an event handler to the button
        showButton.setOnAction(e -> {
            String selectedLocation = locationCombo.getValue();
            resultLabel.setText("You selected: " + selectedLocation);
        });

        VBox root = new VBox(10, locationCombo, showButton, resultLabel);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Step 3: Using addAll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}