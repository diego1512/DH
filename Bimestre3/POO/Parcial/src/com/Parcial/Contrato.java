package com.Parcial;

public abstract class Contrato {
    //ATRIBUTOS//
    private Integer cantidadMeses;
    private Integer duracion;
    private Integer fachaInicio;
    private Boolean sellado;

    //CONSTRUCTOR//

    public Contrato(Integer cantidadMeses, Integer duracion, Integer fachaInicio, Boolean sellado) {
        this.cantidadMeses = cantidadMeses;
        this.duracion = duracion;
        this.fachaInicio = fachaInicio;
        this.sellado = sellado;
    }
    //METODOS//
    public Boolean sePuedeIncorporar(){
        if (this.sellado = true)
            return true;
        else
            return false;
    }

    public Boolean getSellado() {
        return sellado;
    }
}
