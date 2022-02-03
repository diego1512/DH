package com.instituto;

import java.util.ArrayList;
import java.util.List;

public class Programa extends OfertaAcademica{

    private List<OfertaAcademica> ofertasAcademicas;
    private Double descuento;

    public Programa(String nombre, String descripcion, Double descuento) {
        super(nombre, descripcion);
        this.descuento = descuento;
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void agregarOferta(OfertaAcademica ofertaAcademica){
        this.ofertasAcademicas.add(ofertaAcademica);
    }

    @Override
    public Double calcularPrecio() {
        Double sumarPrecio = 0.0;
        for (OfertaAcademica ofertaAcademica : ofertasAcademicas) {
            sumarPrecio += ofertaAcademica.calcularPrecio();
        }
        return sumarPrecio - sumarPrecio*descuento;
    }
}
