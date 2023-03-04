package com.example.proyectopooo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    public static ArrayList<String> fechas;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        String css1 = this.getClass().getResource("Inicio.css").toExternalForm();
        scene.getStylesheets().add(css1);
        stage.show();
    }

    public static void main(String[] args) {
        fechas = new ArrayList<>();
       inicializarAlumnos();
        launch();
    }

    public static void inicializarAlumnos(){
        alumnos.add(new Alumno("carlos mario ruiz pinacho","221220"));
        alumnos.add(new Alumno("Alejandro Diaz Hernandez","223224"));
        alumnos.add(new Alumno("William Rivera Solis","221223"));
        alumnos.add(new Alumno("Bryan de la torre Ruiz","221221"));
        alumnos.add(new Alumno("Mauricio Fernandez torres","223220"));
        alumnos.add(new Alumno("Cesar Ovando Lopez","223221"));

    }
}