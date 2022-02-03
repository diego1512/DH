package com.Parcial;

public class Main {
    public static void main(String[] args) {
        Persona person = new Persona("Diego", "Yepes",1000648040,21);

        Contrato contrac1 = new ContratoMes(6,1,191120,true,150000.00,30,"jefe");

        System.out.printf(String.valueOf(contrac1));
    }
}
