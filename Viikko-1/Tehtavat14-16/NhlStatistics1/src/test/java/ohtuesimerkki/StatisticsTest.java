package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void hakuLoytaaPelaajan() {
        assertTrue(stats.search("Kurri").getName().equals("Kurri"));
    }

    @Test
    public void palauttaaNullJosEiLoydy() {
        assertNull(stats.search("höpölöpö"));
    }

    @Test
    public void palauttaaJoukkueenPelaajat() {
        List<Player> pelaajat = stats.team("PIT");
        Player pelaaja = stats.search("Lemieux");
        assertTrue(pelaajat.contains(pelaaja));
    }

    @Test
    public void parasTykittelijaOikein() {
        List<Player> pelaajat = stats.topScorers(1);
        Player pelaaja = stats.search("Lemieux");
        assertTrue(pelaajat.contains(pelaaja));

    }

    @Test
    public void palauttaaUseammanTykittelijan() {
        List<Player> pelaajat = stats.topScorers(3);
        assertEquals(pelaajat.size(), 4);
    }


}