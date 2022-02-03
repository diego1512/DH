package com.instituto;

public class Test {
    public static void main(String[] args) {

    Instituto DH =  new Instituto();
    DH.agregarCurso(OfertaAcademicaFactory.CODIGO_FRONT_END);
    DH.agregarCurso(OfertaAcademicaFactory.CODIGO_BACK_END);
    DH.agregarCurso(OfertaAcademicaFactory.CODIGO_FULL_STACK);
    DH.agregarCurso("sarasa");
    DH.generarInforme();
    }
}
