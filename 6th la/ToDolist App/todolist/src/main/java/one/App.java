package one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) {

        Label title = new Label("Todo List App");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField taskField = new TextField();
        taskField.setPromptText("Enter your task");

        Button addButton = new Button("Add Task");

        VBox taskList = new VBox(10);

        addButton.setOnAction(e -> {

            String taskText = taskField.getText();

            if (taskText.isEmpty()) {
                return;
            }

            Label taskLabel = new Label(taskText);

            Button deleteButton = new Button("Delete");

            HBox taskRow = new HBox(10);

            taskRow.getChildren().addAll(taskLabel, deleteButton);

            deleteButton.setOnAction(event -> {
                taskList.getChildren().remove(taskRow);
            });

            taskList.getChildren().add(taskRow);

            taskField.clear();
        });

        VBox root = new VBox(15);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(title, taskField, addButton, taskList);

        Scene scene = new Scene(root, 400, 500);

        stage.setTitle("Todo App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}