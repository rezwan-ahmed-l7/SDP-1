package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        ComboBox<String> locationCombo = new ComboBox<>();

        locationCombo.getItems().add("Dhaka");
        locationCombo.getItems().add("Saidpur");
        locationCombo.getItems().add("Chittagong");
        locationCombo.getItems().add("Rajshahi");

        VBox root = new VBox(10, locationCombo);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Step 1: One Item");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}