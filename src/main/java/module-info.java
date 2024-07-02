module com.example.latihan2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.latihan2 to javafx.fxml;
    exports com.example.latihan2;
}