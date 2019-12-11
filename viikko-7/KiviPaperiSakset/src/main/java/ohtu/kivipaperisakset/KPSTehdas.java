package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class KPSTehdas {
    private Scanner scanner;
    private Tuomari tuomari;
    private TekoalyInterface tekoaly;
    private HashMap<String, KPS> tekoalyt;
    private KPS kps;

    public KPSTehdas() {
        scanner = new Scanner(System.in);
        tekoalyt = new HashMap<>();
        tekoalyt.put("a", this.pelaajaVsPelaaja());
        tekoalyt.put("b", this.tekoaly());
        tekoalyt.put("c", this.parempiTekoaly());
    }

    public KPS haeKps(String charakteri) {
        return tekoalyt.get(charakteri);
    }

    public KPS pelaajaVsPelaaja() {
        tuomari = new Tuomari();
        return new KPSPelaajaVsPelaaja(tuomari, scanner);
    }

    public KPS parempiTekoaly() {
        tuomari = new Tuomari();
        tekoaly = new TekoalyParannettu(20);
        return new KPSParempiTekoaly(tuomari, tekoaly, scanner);
    }

    public KPS tekoaly() {
        tuomari = new Tuomari();
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
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            kps = this.haeKps(vastaus);
            kps.pelaa();

        }
    }
}
