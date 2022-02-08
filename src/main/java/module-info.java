module com.example.canvasproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.canvasproject to javafx.fxml;
    exports com.example.canvasproject;
}