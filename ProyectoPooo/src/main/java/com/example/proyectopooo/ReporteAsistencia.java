package com.example.proyectopooo;
import java.util.ArrayList;

public class ReporteAsistencia extends Reporte{

    
    public ReporteAsistencia() {
        super();
    }

    @Override
    public ArrayList<Alumno> generarReporte(int i,ArrayList<Alumno> alumnos){

        ArrayList<Alumno> alumnosA = new ArrayList<>();
        for(Alumno a: alumnos){
            if(a.verAsistencia(i) == 'a'){
                alumnosA.add(a);
            }


        }
        return alumnosA;
    }
}
