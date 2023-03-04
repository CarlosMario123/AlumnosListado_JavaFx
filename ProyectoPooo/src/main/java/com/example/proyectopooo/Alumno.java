package com.example.proyectopooo;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String matricula;
    private ArrayList<Character> asistencia = new ArrayList<>();
    private String estatus;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public Alumno(String nombre, String matricula, String estatus, String fecha) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.estatus = estatus;
        this.fecha = fecha;
    }
    public Alumno(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;

    }



    public String getEstatus() {
        return estatus;
    }



    public void agregarAsistencia(char a){

        asistencia.add(a);
    }

    public String mandarInformacion(){
        return "Nombre del alumno: " + nombre + "\n" + "matricula: " + matricula + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public char verAsistencia(int indice){
        return asistencia.get(indice);
    }



    public void removerUltimaAsistencia(){
        asistencia.remove(asistencia.size() -1);
    }
}
