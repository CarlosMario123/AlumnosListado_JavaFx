package com.example.proyectopooo;
import java.util.ArrayList;

public class ReportePermisos extends Reporte {

    public ReportePermisos() {
        super();
    }
    @Override
    public ArrayList<Alumno> generarReporte(int i,ArrayList<Alumno> alumnos){
    
        ArrayList<Alumno> alumnosP = new ArrayList<>();
        for(Alumno a: alumnos){
            if(a.verAsistencia(i) == 'p'){
                alumnosP.add(a);
            }
          
           
    }
    return alumnosP;
}
}
