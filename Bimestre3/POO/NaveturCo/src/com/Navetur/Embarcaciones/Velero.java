package com.Navetur.Embarcaciones;

import com.Navetur.Capitan;

public class Velero extends Embarcacion {
    // ATRIBUTOS
    private Integer cantidadMastiles;

    // CONSTRUCTOR
    public Velero(Capitan capitan, Double precioBase, Double valorAdicional, Integer anioFabricacion, Double eslora, Integer cantidadMastiles){
        super(capitan, precioBase, valorAdicional, anioFabricacion, eslora);
        this.cantidadMastiles =  cantidadMastiles;
    }

    // METODOS
    public Boolean esGrande(){
        if(this.cantidadMastiles > 4) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Double valorDepreciacion(Integer anio) {
        return super.getPrecioBase() - 100*anio;
    }
}
