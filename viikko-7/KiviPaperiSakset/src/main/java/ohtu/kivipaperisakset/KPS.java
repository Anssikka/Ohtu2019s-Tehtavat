package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPS {
    public Scanner scanner;
    public Tuomari tuomari;
    public TekoalyInterface tekoaly;


    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);

        pelaaKierroksia(ekanSiirto, tokanSiirto);

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    public void pelaaKierroksia(String ekanSiirto, String tokanSiirto) {

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");

            ekanSiirto = scanner.nextLine();
            tokanSiirto = tekoaly.annaSiirto();

            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }
    }

    static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public void asetaTuomari(Tuomari tuomari) {
        this.tuomari = tuomari;
    }

    public void asetaTekoaly(TekoalyInterface tekoaly) {
        this.tekoaly = tekoaly;
    }

    public void asetaScanneri(Scanner scanner) {
        this.scanner = scanner;
    }
}
