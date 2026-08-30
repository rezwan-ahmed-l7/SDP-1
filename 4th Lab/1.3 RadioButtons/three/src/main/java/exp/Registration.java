package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label genderLabel = new Label("Select Gender:");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");

        VBox root = new VBox(genderLabel, maleRadio, femaleRadio);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Gender Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}