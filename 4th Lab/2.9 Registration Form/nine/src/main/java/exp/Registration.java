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

        Label locLabel = new Label("Location:");

        ComboBox<String> locationCombo = new ComboBox<>();

        locationCombo.getItems().addAll("Dhaka", "Saidpur", "Chittagong", "Rajshahi", "Khulna", "Barishal", "Sylhet");
        locationCombo.setValue("Dhaka");
        locationCombo.setPromptText("Select your city");

        HBox locBox = new HBox(10, locLabel, locationCombo);

        Button showButton = new Button("Show Selection");
        Label resultLabel = new Label();

        showButton.setOnAction(e -> {
            String selected = locationCombo.getValue();
            if (selected != null) {
                resultLabel.setText("Selected location: " + selected);
            } else {
                resultLabel.setText("No location selected");
            }
        });

        VBox root = new VBox(15, locBox, showButton, resultLabel);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Location ComboBox - Ready for Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}