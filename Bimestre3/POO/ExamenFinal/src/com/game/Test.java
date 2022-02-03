package com.game;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Personaje personaje = new Personaje();
        personaje.agregarHabilidad("saltar");
        personaje.agregarHabilidad("Disparar");
        personaje.agregarHabilidad("Disparar_saltar");
        personaje.mostarHabilidad();
    }
}
