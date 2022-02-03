package com.instituto;

public class OfertaAcademicaFactory {

    private static OfertaAcademicaFactory instance;

    public static final String CODIGO_FULL_STACK = "full-stack";
    public static final String CODIGO_BACK_END = "back-end";
    public static final String CODIGO_FRONT_END = "front-end";

    private OfertaAcademicaFactory(){

    }

    public static OfertaAcademicaFactory getInstance(){
        if(instance == null){
            instance = new OfertaAcademicaFactory();
        }
        return instance;
    }

    public OfertaAcademica generarOfertaAcademica(String codigo) throws OfertaAcademicaFactoryException{
        switch (codigo) {
            case CODIGO_FRONT_END:
                return new Curso("front-end", "ensenia front-end", 16.0, 2.0, 1000.0);
            case CODIGO_BACK_END:
                return new Curso("back-end", "ensenia back-end", 20.0, 2.0, 900.0);
            case CODIGO_FULL_STACK:
                Programa programa = new Programa("full-stack", "enseniamos de todo", 0.2);
                programa.agregarOferta(generarOfertaAcademica(CODIGO_FRONT_END));
                programa.agregarOferta(generarOfertaAcademica(CODIGO_BACK_END));
                return programa;
            default:
                throw new OfertaAcademicaFactoryException(codigo + " no es un codigo valido");
        }
    }
}
