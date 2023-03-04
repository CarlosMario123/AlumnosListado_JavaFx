package com.example.proyectopooo;
import java.util.ArrayList;

public class ReporteFaltas extends Reporte {

    public ReporteFaltas() {
        super();
    }

    @Override
    public ArrayList<Alumno> generarReporte(int i,ArrayList<Alumno> alumnos){

        ArrayList<Alumno> alumnosF = new ArrayList<>();
        for(Alumno a: alumnos){
            if(a.verAsistencia(i) == 'f'){
                alumnosF.add(a);
            }


        }
        return alumnosF;
    }
    
}
