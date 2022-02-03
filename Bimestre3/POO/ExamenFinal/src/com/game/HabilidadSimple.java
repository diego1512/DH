package com.game;

public class HabilidadSimple extends Habilidad {
    //ATRIBUTOS//
    private String nombre;

    //CONSTRUCTOR//
    public HabilidadSimple(String nombre, String descripcion, String nombre1) {
        super(nombre, descripcion);
        this.nombre = nombre1;
    }
    //METODOS//
    @Override
    public Double calcularPuntajeHabilidad() {
        return null;
    }


}
