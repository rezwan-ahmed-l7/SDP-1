module one {
    requires javafx.controls;
    requires javafx.fxml;

    opens one to javafx.fxml;
    exports one;
}
