package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTehdas {
    private Scanner scanner;
    private Tuomari tuomari;
    private TekoalyInterface tekoaly;
    private KPS kps;

    public KPSTehdas() {
        scanner = new Scanner(System.in);
        tuomari = new Tuomari();
    }

    public KPS pelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja(tuomari, scanner);
    }

    public KPS parempiTekoaly() {
        tekoaly = new TekoalyParannettu(20);
        return new KPSParempiTekoaly(tuomari, tekoaly, scanner);
    }

    public KPS tekoaly() {
        tekoaly = new Tekoaly();
        return new KPSTekoaly(tuomari, tekoaly, scanner);
    }

    public void peluuta() {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                kps = this.pelaajaVsPelaaja();
                kps.pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                kps = this.tekoaly();
                kps.pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                kps = this.parempiTekoaly();
                kps.pelaa();
            } else {
                break;
            }

        }
    }
}
