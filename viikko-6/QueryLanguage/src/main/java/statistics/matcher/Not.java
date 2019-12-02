package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    private Matcher matseri;

    public Not(Matcher matseri) {
        this.matseri = matseri;
    }

    @Override
    public boolean matches(Player p) {

        return !matseri.matches(p);
    }
}
