package com.game;

public abstract class Habilidad {
    //ATRIBUTOS//
    private String nombre;
    private String descripcion;


    //CONSTRUCTOR//
    public Habilidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //METODOS//
    public abstract Double calcularPuntajeHabilidad();

    //GET//
    public String getNombre() {
        return nombre;
    }
}
