package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create Buttons
        Button btn1 = new Button("Click Me");
        Button btn2 = new Button("Press Me");

        // Event handling
        btn1.setOnAction(e -> System.out.println("Button 1 clicked!"));
        btn2.setOnAction(e -> System.out.println("Button 2 clicked!"));

        // Layout
        VBox root = new VBox(10); // 10 px spacing
        root.getChildren().addAll(btn1, btn2);

        // Scene
        Scene scene = new Scene(root, 400, 300);

        // Stage
        primaryStage.setTitle("Multiple Buttons Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}