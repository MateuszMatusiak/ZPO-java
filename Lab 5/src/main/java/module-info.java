module main.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens main.lab5 to javafx.fxml;
    exports main.lab5;
}