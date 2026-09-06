module todolist {
    requires javafx.controls;
    requires javafx.fxml;

    opens todolist to javafx.fxml;
    exports todolist;
}
