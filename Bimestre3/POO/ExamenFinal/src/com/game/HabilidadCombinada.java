package com.game;

import java.util.ArrayList;
import java.util.List;

public class HabilidadCombinada extends Habilidad {
    //ATRIBUTOS//
    private List<Habilidad> habilidadades;
    private Integer multiplicador;


    //CONSTRUCTOR//
    public HabilidadCombinada(String nombre, String descripcion, List<Habilidad> habilidadades, Integer multiplicador) {
        super(nombre, descripcion);
        this.multiplicador = multiplicador;
        this.habilidadades = new ArrayList();
    }

    //METODOS//
    public void agregarHabilidad(Habilidad habilidad) {
        this.habilidadades.add(habilidad);
    }

    @Override
    public Double calcularPuntajeHabilidad() {
        return null;
    }
}
