package com.Navetur;

import com.Navetur.Embarcaciones.Catamaran;
import com.Navetur.Embarcaciones.Embarcacion;
import com.Navetur.Embarcaciones.Velero;
import com.Navetur.Embarcaciones.Yate;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Capitan cap = new Capitan("Popeye", "Marino", 456);

        Embarcacion velero1 = new Velero(cap, 3000.0, 500.0, 2019, 100.0, 5);
        Embarcacion yate1 = new Yate(cap, 5000.0,1000.0, 2019, 100.0, 3);
        Embarcacion yate2 = new Yate(cap, 5000.0,1000.0, 2019, 100.0, 5);
        Embarcacion c1 = new Catamaran(cap, 2000.0, 1000.0, 2017, 40.0);

        velero1.valorDepreciacion(3);
        yate1.valorDepreciacion(4);
        c1.valorDepreciacion(2);


    }
}
