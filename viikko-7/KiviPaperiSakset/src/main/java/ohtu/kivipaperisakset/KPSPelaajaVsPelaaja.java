package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPS {
    public KPSPelaajaVsPelaaja(Tuomari tuomari, Scanner scanner) {
        this.asetaTuomari(tuomari);
        this.asetaScanneri(scanner);
    }

    @Override
    public void pelaa() {

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();

        pelaaKierroksia(ekanSiirto, tokanSiirto);

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    @Override
    public void pelaaKierroksia(String ekanSiirto, String tokanSiirto) {
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }
    }

}