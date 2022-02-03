package com.Navetur.Embarcaciones;

import com.Navetur.Capitan;

public class Yate extends Embarcacion implements Comparable{
    // ATRIBUTOS
    private Integer cantidadCamarotes;

    // CONSTRUCTOR
    public Yate(Capitan capitan, Double precioBase, Double valorAdicional, Integer anioFabricacion, Double eslora, Integer cantidadCamarotes) {
        super(capitan, precioBase, valorAdicional, anioFabricacion, eslora);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    @Override
    public int compareTo(Object o) {
        int num = 0;
        Yate otroYate = (Yate) o;
        /*
        if(this.cantidadCamarotes > yate.cantidadCamarotes)
            return 1;
        if(this.cantidadCamarotes < yate.cantidadCamarotes)
            return -1;
        return 0;
         */

        return this.cantidadCamarotes - otroYate.cantidadCamarotes;
    }

    @Override
    public Double valorDepreciacion(Integer anio) {
        return super.getPrecioBase() - 200*anio;
    }
}
