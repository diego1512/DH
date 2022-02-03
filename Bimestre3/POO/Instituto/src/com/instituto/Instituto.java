package com.instituto;

import java.util.ArrayList;
import java.util.List;

public class Instituto {

    private List<OfertaAcademica> ofertasAcademicas;

    public Instituto() {
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void agregarCurso(String codigo){

        try{
            this.ofertasAcademicas.add(OfertaAcademicaFactory.getInstance().generarOfertaAcademica(codigo));
        }
        catch (OfertaAcademicaFactoryException e) {
            e.printStackTrace();
        }
    }

    public void generarInforme(){
        for (OfertaAcademica ofertaAcademica : ofertasAcademicas) {
            System.out.println("nombre: " + ofertaAcademica.getNombre() + " precio: " + ofertaAcademica.calcularPrecio());
        }
    }
}
