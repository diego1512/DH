package com.game;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    //ATRIBUTOS/
    private List<Habilidad> habilidadades = new ArrayList();


    //CONSTRUCTOR//
    public Personaje(List<Habilidad> habilidadades) {
        this.habilidadades = habilidadades;
    }

    //METODOS//
    public void agregarHabilidad(String codigo) {
        try {
            this.habilidadades.add(HabilidadFactory.getInstance().generarHabilidad(codigo));
        } catch (HabilidadFactoryException var3) {
            var3.printStackTrace();
        }
        public void mostarHabilidad () {
            Iterator var1 = this.habilidadades.iterator();

            while (var1.hasNext()) {
                HabilidadCombinada ofertaAcademica = (HabilidadCombinada) var1.next();
                PrintStream var10000 = System.out;
                String var10001 = ofertaAcademica.getNombre();
                var10000.println("nombre: " + var10001 + " precio: " + ofertaAcademica.calcularPuntajeHabilidad());
            }
        }
    }

}
