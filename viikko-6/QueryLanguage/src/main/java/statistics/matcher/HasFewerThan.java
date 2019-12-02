package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private HasAtLeast hasa;

    public HasFewerThan(int value, String category) {
        hasa = new HasAtLeast(value, category);
    }

    @Override
    public boolean matches(Player p) {
        boolean doesItMatch = hasa.matches(p);

        return !doesItMatch;
    }
}
