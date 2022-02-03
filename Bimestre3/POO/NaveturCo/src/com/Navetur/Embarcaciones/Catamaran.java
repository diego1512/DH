package com.Navetur.Embarcaciones;

import com.Navetur.Capitan;

public class Catamaran extends Embarcacion{

    public Catamaran(Capitan capitan, Double precioBase, Double valorAdicional, Integer anioFabricacion, Double eslora) {
        super(capitan, precioBase, valorAdicional, anioFabricacion, eslora);
    }

    @Override
    public Double valorDepreciacion(Integer anio) {
        return 1.0;
    }


}
