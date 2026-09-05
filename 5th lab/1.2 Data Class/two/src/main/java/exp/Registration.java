package exp;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;

// A simple Person class to hold data for the TableView
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a TableView and add columns to connect to the Person class properties
        TableView<Person> table = new TableView<>();

        TableColumn<Person, String> col1 = new TableColumn<>("Name");
        TableColumn<Person, Integer> col2 = new TableColumn<>("Age");

        // Bind the properties of the Person class to the columns to get the data
        col1.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            return new SimpleStringProperty(p.name);
        });

        col2.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            return new SimpleIntegerProperty(p.age).asObject();
        });

        table.getColumns().addAll(col1, col2);

        // Add data to the TableView
        ObservableList<Person> data = FXCollections.observableArrayList();
        data.add(new Person("Paris", 25));
        data.add(new Person("Rex", 30));
        data.add(new Person("Prince", 28));

        table.setItems(data);

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