package com.Parcial;

public class ContratoHora extends Contrato implements Comparable{
    //ATRIBUTOS//
    private Integer cantidadHoras;
    private Double valorHora;

    //CONSTRUCTOR//
    public ContratoHora(Integer cantidadMeses, Integer duracion, Integer fachaInicio, Boolean sellado, Integer cantidadHoras, Double valorHora) {
        super(cantidadMeses, duracion, fachaInicio, sellado);
        this.cantidadHoras = cantidadHoras;
        this.valorHora = valorHora;
    }
    //METODOS//
    @Override
    public int compareTo(Object o) {
        int num = 0;
        ContratoHora contrato =(ContratoHora) o;
        if (this.cantidadHoras > contrato.cantidadHoras)
            return 1;
        if (this.cantidadHoras < contrato.cantidadHoras)
            return -1;
        return 0;
    }
    @Override
    public Boolean sePuedeIncorporar() {
        if (super.getSellado() == true)
            return true;
        else
            return false;
    }
}
