package com.Navetur.Embarcaciones;

import com.Navetur.Capitan;

public abstract class Embarcacion {
    // ATRIBUTOS
    private Capitan capitan;
    private Double precioBase;
    private Double valorAdicional;
    private Integer anioFabricacion;
    private Double eslora;

    // CONSTRUCTOR
    public Embarcacion(Capitan capitan, Double precioBase, Double valorAdicional, Integer anioFabricacion, Double eslora) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.valorAdicional = valorAdicional;
        this.anioFabricacion = anioFabricacion;
        this.eslora = eslora;
    }
    // ATRIBUTOS
    public Double calcularMontoAlquier(){
        Double precio = this.precioBase;
        if(anioFabricacion > 2020)
            precio += this.valorAdicional;
        return precio;
    }

    public abstract Double valorDepreciacion(Integer anio);

    public Double getPrecioBase() {
        return precioBase;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public Integer getAnioFabricacion() {
        return anioFabricacion;
    }
}
