package com.example.proyectopooo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Reportes implements Initializable {

    @FXML
    private Button salir;

    @FXML
    private TableView<Alumno> tabla1;




    @FXML
    private TableColumn tableMatricula;

    @FXML
    private TableColumn tableStatus;

    @FXML
    private TableColumn tablenombre;
    @FXML
    private TableColumn<Alumno, String> fechas;

    private ObservableList<Alumno> alumnos;


    //son todas la fechas que se realizo
    private int incremento = 0;

    @FXML
    void regresarMenu(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        String css1 = this.getClass().getResource("Inicio.css").toExternalForm();
        scene.getStylesheets().add(css1);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      alumnos = FXCollections.observableArrayList();


      this.tablenombre.setCellValueFactory(new PropertyValueFactory("nombre"));
      this.tableMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
      this.tableStatus.setCellValueFactory(new PropertyValueFactory("estatus"));
      this.fechas.setCellValueFactory(new PropertyValueFactory("fecha"));

        for(incremento = 0; incremento < HelloApplication.fechas.size();incremento++) {
            rellenarTablaF();
            rellenarTablaP();
            rellenarTablaA();
        }
        tabla1.setItems(alumnos);

    }



    private void rellenarTablaP(){
        ReportePermisos reportePermisos = new ReportePermisos();
        Alumno b;
        String n;
        String m;
        String e;
        for(Alumno a:reportePermisos.generarReporte(incremento,HelloApplication.alumnos)){
             n = a.getNombre();
             m = a.getMatricula();
             e = generarEstatus(a.verAsistencia(incremento));
             b = new Alumno(n,m,e,HelloApplication.fechas.get(incremento));
             alumnos.add(b);
        }

    }

    private void rellenarTablaF(){
        ReporteFaltas reporteFaltas = new ReporteFaltas();
        Alumno b;
        String n;
        String m;
        String e;
        for(Alumno a:reporteFaltas.generarReporte(incremento,HelloApplication.alumnos)){
            n = a.getNombre();
            m = a.getMatricula();
            e = generarEstatus(a.verAsistencia(incremento));
            b = new Alumno(n,m,e,HelloApplication.fechas.get(incremento));
            alumnos.add(b);
        }

    }


    private void rellenarTablaA(){
       ReporteAsistencia asistencia = new ReporteAsistencia();
        Alumno b;
        String n;
        String m;
        String e;
        for(Alumno a:asistencia.generarReporte(0,HelloApplication.alumnos)){
            n = a.getNombre();
            m = a.getMatricula();
            e = generarEstatus(a.verAsistencia(0));
            b = new Alumno(n,m,e,HelloApplication.fechas.get(incremento));
            alumnos.add(b);
        }


    }


    private String generarEstatus(char a){
        String estatus = "";
        switch(a){
            case 'a':
                estatus = "asistio";
                break;

            case 'f':
                estatus = "falto";
                break;


            case 'p':
                estatus = "permiso";
                break;
        }
        return estatus;
    }
}
