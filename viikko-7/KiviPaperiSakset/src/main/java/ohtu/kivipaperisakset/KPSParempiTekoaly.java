package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS{

    public KPSParempiTekoaly(Tuomari tuomari, TekoalyInterface tekoaly, Scanner scanner) {
        this.asetaTuomari(tuomari);
        this.asetaTekoaly(tekoaly);
        this.asetaScanneri(scanner);
    }

}
