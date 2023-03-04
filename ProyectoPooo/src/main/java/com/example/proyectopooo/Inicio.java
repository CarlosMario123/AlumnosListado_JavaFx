package com.example.proyectopooo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Inicio {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button butonm;

    @FXML
    private Button buttonP;

    @FXML
    private ImageView imagen_1;

    @FXML
    private ImageView imagen_2;

    @FXML
    void cambiarTomarLista(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("PasarLista.fxml"));
       Node nodo = (Node) event.getSource();
       stage = (Stage) nodo.getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }

    @FXML
    void mostrarLista(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reportes.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}