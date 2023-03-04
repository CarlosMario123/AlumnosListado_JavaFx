module com.example.proyectopooo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectopooo to javafx.fxml;
    exports com.example.proyectopooo;
}