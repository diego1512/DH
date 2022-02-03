package com.Parcial;

public class ContratoMes extends Contrato{
    //ATRIBUTOS//
    private Double salarioMensual;
    private Integer horasTotales;
    private String cargo;

    //CONSTRUCTOR//
    public ContratoMes(Integer cantidadMeses, Integer duracion, Integer fachaInicio, Boolean sellado, Double salarioMensual, Integer horasTotales, String cargo) {
        super(cantidadMeses, duracion, fachaInicio, sellado);
        this.salarioMensual = salarioMensual;
        this.horasTotales = horasTotales;
        this.cargo = cargo;
    }
    //METODOS//
    @Override
    public Boolean sePuedeIncorporar() {
        if (super.getSellado() == true)
            return true;
        else
            return false;
    }
    public Boolean CargoJefe (String nom){
        if (this.cargo == nom)
            return true;
        else
            return false;
    }
}
