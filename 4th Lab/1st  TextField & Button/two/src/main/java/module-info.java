module exp {
    requires javafx.controls;
    requires javafx.fxml;

    opens exp to javafx.fxml;
    exports exp;
}
