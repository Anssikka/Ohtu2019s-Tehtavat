
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKAVASTUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = alustaTaulukko(new int[KAPASITEETTI]);
        alkioidenLkm = 0;
        this.kasvatusKoko = OLETUSKAVASTUS;
    }

    public IntJoukko(int KAPASITEETTI) {
        if (KAPASITEETTI < 0) {
            return;
        }
        ljono = alustaTaulukko(new int[KAPASITEETTI]);
        alkioidenLkm = 0;
        this.kasvatusKoko = OLETUSKAVASTUS;
    }
    
    
    public IntJoukko(int KAPASITEETTI, int kasvatusKoko) {
        if (KAPASITEETTI < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin pitää olla positiivinen");
        }
        if (kasvatusKoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon pitää olla positiivinen");
        }
        ljono = alustaTaulukko(new int[KAPASITEETTI]);
        alkioidenLkm = 0;
        this.kasvatusKoko = kasvatusKoko;
    }

    public int[] alustaTaulukko(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        return taulukko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % ljono.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }
    
    public void kasvataTaulukkoa() {
        int[] vanhaTaulukko = ljono;
        kopioiTaulukko(ljono, vanhaTaulukko);
        ljono = new int[alkioidenLkm + kasvatusKoko];
        kopioiTaulukko(vanhaTaulukko, ljono);
    }

    public boolean kuuluu(int luku) {
        int on = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                on++;
            }
        }
        return (on > 0);
    }

    public boolean poista(int luku) {
        int luvunIndeksi = luvunIndeksi(luku);
        if (luvunIndeksi != -1) {
            ljono[luvunIndeksi] = 0;
            siirraLukujaYksiVasemmalle(luvunIndeksi);
        }
        return (luvunIndeksi != -1);


    }

    public void siirraLukujaYksiVasemmalle(int indeksista) {
        for (int j = indeksista; j < alkioidenLkm - 1; j++) {
            int apustajaLuku = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apustajaLuku;
        }
        alkioidenLkm--;
    }

    public int luvunIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String palautettavaString = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                palautettavaString += ljono[i];
                palautettavaString += ", ";
            }
            palautettavaString += ljono[alkioidenLkm - 1];
            palautettavaString += "}";
            return palautettavaString;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }
        
}