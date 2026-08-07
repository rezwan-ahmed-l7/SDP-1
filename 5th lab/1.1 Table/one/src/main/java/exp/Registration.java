package exp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        TableView<String> table = new TableView<>();

        // Create columns
        TableColumn<String, String> col1 = new TableColumn("Name");
        TableColumn<String, Integer> col2 = new TableColumn("Age");

        table.getColumns().addAll(col1, col2);

        VBox root = new VBox(10, table);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("My Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}