package exp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// User class to hold data
class User {
    String name;
    String dob;
    String gender;
    String reservation;
    String tech;
    String qualification;
    String location;

    User(String name, String dob, String gender, String reservation,
            String tech, String qualification, String location) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.reservation = reservation;
        this.tech = tech;
        this.qualification = qualification;
        this.location = location;
    }
}

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ========== 1. TABLE VIEW ==========
        TableView<User> table = new TableView<>();

        TableColumn<User, String> col1 = new TableColumn<>("Name");
        TableColumn<User, String> col2 = new TableColumn<>("DOB");
        TableColumn<User, String> col3 = new TableColumn<>("Gender");
        TableColumn<User, String> col4 = new TableColumn<>("Reservation");
        TableColumn<User, String> col5 = new TableColumn<>("Technology");
        TableColumn<User, String> col6 = new TableColumn<>("Qualification");
        TableColumn<User, String> col7 = new TableColumn<>("Location");

        col1.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.name);
        });

        col2.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.dob);
        });

        col3.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.gender);
        });

        col4.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.reservation);
        });

        col5.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.tech);
        });

        col6.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.qualification);
        });

        col7.setCellValueFactory(cellData -> {
            User u = cellData.getValue();
            return new SimpleStringProperty(u.location);
        });

        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);

        // ========== 2. DATA ==========
        ObservableList<User> userList = FXCollections.observableArrayList();
        userList.add(new User("Rajit", "01-01-1995", "Male", "Yes", "Java", "BSC", "Dhaka"));
        userList.add(new User("Awal", "02-02-1996", "Male", "No", "DotNet", "MSC", "Saidpur"));

        table.setItems(userList);

        // ========== 3. INPUT FIELDS ==========
        // Name
        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");

        // DOB
        DatePicker dobPicker = new DatePicker();
        dobPicker.setPromptText("Select DOB");

        // Gender (RadioButton)
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        maleRadio.setSelected(true);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio);

        // Reservation (RadioButton)
        ToggleGroup resGroup = new ToggleGroup();
        RadioButton yesRadio = new RadioButton("Yes");
        yesRadio.setToggleGroup(resGroup);
        yesRadio.setSelected(true);
        RadioButton noRadio = new RadioButton("No");
        noRadio.setToggleGroup(resGroup);
        HBox resBox = new HBox(10, yesRadio, noRadio);

        // Technology (CheckBox)
        CheckBox javaCheck = new CheckBox("Java");
        CheckBox dotnetCheck = new CheckBox("DotNet");
        HBox techBox = new HBox(10, javaCheck, dotnetCheck);

        // Qualification (ComboBox)
        ComboBox<String> qualCombo = new ComboBox<>();
        qualCombo.getItems().addAll("SSC", "HSC", "BSC", "MSC");
        qualCombo.setValue("BSC");

        // Location (ComboBox)
        ComboBox<String> locCombo = new ComboBox<>();
        locCombo.getItems().addAll("Dhaka", "Saidpur", "Chittagong", "Rajshahi", "Khulna", "Barishal", "Sylhet");
        locCombo.setValue("Dhaka");

        // ========== 4. REGISTER BUTTON ==========
        Button registerButton = new Button("Register User");
        registerButton.setOnAction(e -> {
            String name = nameField.getText();
            String dob = dobPicker.getValue().toString();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String reservation = yesRadio.isSelected() ? "Yes" : "No";

            String tech = "";
            if (javaCheck.isSelected())
                tech = tech + "Java ";
            if (dotnetCheck.isSelected())
                tech = tech + "DotNet";
            if (tech.isEmpty())
                tech = "None";

            String qualification = qualCombo.getValue();
            String location = locCombo.getValue();

            userList.add(new User(name, dob, gender, reservation, tech, qualification, location));

            // Clear fields
            nameField.clear();
            dobPicker.setValue(null);
            maleRadio.setSelected(true);
            yesRadio.setSelected(true);
            javaCheck.setSelected(false);
            dotnetCheck.setSelected(false);
            qualCombo.setValue("BSC");
            locCombo.setValue("Dhaka");
        });

        // ========== 5. LAYOUT ==========
        VBox inputBox = new VBox(10,
                new Label("Name:"), nameField,
                new Label("DOB:"), dobPicker,
                new Label("Gender:"), genderBox,
                new Label("Reservation:"), resBox,
                new Label("Technology:"), techBox,
                new Label("Qualification:"), qualCombo,
                new Label("Location:"), locCombo,
                registerButton);

        VBox root = new VBox(15, table, inputBox);

        // ========== 6. SCENE & STAGE ==========
        Scene scene = new Scene(root, 600, 700);
        primaryStage.setTitle("Registration Form with Table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}