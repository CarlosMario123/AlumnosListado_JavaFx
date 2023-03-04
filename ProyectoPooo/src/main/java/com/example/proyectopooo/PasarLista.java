package com.example.proyectopooo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

public class PasarLista implements Initializable {

    @FXML
    private RadioButton asistio;

    @FXML
    private Button atras;

    @FXML
    private RadioButton falto;

    @FXML
    private Label fechaMostrar;

    @FXML
    private RadioButton permiso;

    @FXML
    private Button salir;

    @FXML
    private Button siguiente;

    @FXML
    private Label txtMatricula;

    @FXML
    private Label txtNombre;


    //lista de los alumnos
    ArrayList<Alumno> alumnos;
    boolean[] lista;
    char[] asistencia;
    private char anterior;

    //el que permitira contralar las posiciones
    int incremento = -1;
    @FXML
    void avanzar(ActionEvent event) throws IOException {
        atras.setVisible(true);
        anterior = comprobarSeleccionado();
        verRadioButton();
        incremento++;
        if(incremento >= 1){
            agregarAsistencia();
        }
       if(incremento < alumnos.size()){

               Alumno a = alumnos.get(incremento);

               txtNombre.setText("Nombre " + a.getNombre());
               txtMatricula.setText("Matricula: " + a.getMatricula());





       }else{
           permiso.setVisible(false);
           falto.setVisible(false);
           asistio.setVisible(false);
           txtNombre.setText("Desea terminar");
           txtMatricula.setText("");
           siguiente.setText("Terminar");
       }

       if(incremento == alumnos.size() + 1){



           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Diálogo de información...");
           alert.setHeaderText(null);
           alert.setContentText("Pase de lista realizado correctamente");
           alert.showAndWait();

           //Rellenamos las asistencia
           for(int i = 0; i <alumnos.size();i++){
               alumnos.get(i).agregarAsistencia(asistencia[i]);
           }
           cambiarScena(event);
       }

    }

    @FXML
    void regresarMenu(ActionEvent event) {

    }

    @FXML
    void retroceder(ActionEvent event) {
        permiso.setVisible(true);
        falto.setVisible(true);
        asistio.setVisible(true );
        incremento--;
        if(incremento <= -1){
            incremento = 0;
            System.out.println("helo");
        }else{

            Alumno a = alumnos.get(incremento);
            txtNombre.setText("Nombre " + a.getNombre());
            txtMatricula.setText("Matricula: " + a.getMatricula());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate fecha = LocalDate.now();
        String fecha1 = fecha.plusDays(HelloApplication.fechas.size()).toString();
        HelloApplication.fechas.add(fecha1);
        fechaMostrar.setText(fecha1);
        //agrupar los radioButon
        ToggleGroup tg = new ToggleGroup();
        asistio.setToggleGroup(tg);
        permiso.setToggleGroup(tg);
        falto.setToggleGroup(tg);
        asistio.selectedProperty();
        atras.setVisible(false);
        permiso.setVisible(false);
        falto.setVisible(false);
        asistio.setVisible(false);
        incremento = -1;
        //modificar set
         alumnos = HelloApplication.alumnos;
         txtNombre.setText("pase de lista");
         txtMatricula.setText("");
        //lista que comprueba que el alumno se le paso lista
         lista = new boolean[alumnos.size()];
         asistencia = new char[alumnos.size()];

    }

    private void verRadioButton(){
        permiso.setVisible(true);
        falto.setVisible(true);
        asistio.setVisible(true);
    }
    private char comprobarSeleccionado(){
        RadioButton[] radios = {falto,permiso};
        char [] caracter = {'f','p'};
        char c = 'a';

        for(int i = 0; i <radios.length;i++){
            if(radios[i].isSelected()){
               c = caracter[i];;
            }

        }
        return c;
    }

    public void cambiarScena(ActionEvent event) throws IOException {
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


    private void agregarAsistencia(){

        if((incremento- 1) < asistencia.length )
        asistencia[incremento - 1] = anterior;
    }
}
