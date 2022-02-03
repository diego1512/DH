package com.game;

public class HabilidadFactory {
    //ATRIBUTOS/
    private static HabilidadFactory instance;
    public static final String CODIGO_SALTAR = "saltar";
    public static final String CODIGO_DISPARAR= "Disparar";
    public static final String CODIGO_DISPARAR_SALTAR = "Disparar_saltar";

    //CONSTRUCTOR//
    public HabilidadFactory() {
    }

    //METODOS//
    public static HabilidadFactory getInstance() {
        if (instance == null) {
            instance = new HabilidadFactory();
        }

        return instance;
    }
    public Habilidad generarHabilidad(String codigo) throws HabilidadFactoryException {
        byte var3 = -1;
        switch(codigo.hashCode()) {
            case -1879141942:
                if (codigo.equals("full-stack")) {
                    var3 = 2;
                }
                break;
            case 126590775:
                if (codigo.equals("front-end")) {
                    var3 = 0;
                }
                break;
            case 2119775989:
                if (codigo.equals("back-end")) {
                    var3 = 1;
                }
        }

        switch(var3) {
            case 0:
                return new Habilidad("saltar", "saltar", 16.0D, 2.0D, 1000.0D) {
                    @Override
                    public Double calcularPuntajeHabilidad() {
                        return null;
                    }
                };
            case 1:
                return new Habilidad("Disparar", "Disparar", 20.0D, 2.0D, 900.0D);
            case 2:
                HabilidadCombinada combinada = new HabilidadCombinada("Disparar_saltar", "Disparar_saltar", 0.2D);
                combinada.agregarHabilidad(this.generarHabilidad("saltar"));
                combinada.agregarHabilidad(this.generarHabilidad("Disparar"));
                return combinada;
            default:
                throw new HabilidadFactoryException(codigo + " no es un codigo valido");
        }
    }

}
