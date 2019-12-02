package statistics.matcher;

import statistics.Player;

import java.util.ArrayList;

public class QueryBuilder {
    ArrayList<Matcher> matchers = new ArrayList<>();

    public QueryBuilder() {

    }
    public Matcher build() {
        Matcher matseri = new And(matchers.toArray(new Matcher[matchers.size()]));

        this.matchers.clear();


        return matseri;
    }

    public QueryBuilder playsIn(String joukkue) {
        matchers.add(new PlaysIn(joukkue));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String field) {
        matchers.add(new HasFewerThan(value, field));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String field) {
        matchers.add(new HasAtLeast(value, field));
        return this;
    }

    public QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        this.matchers.add(new Or(matcher1, matcher2));

        return this;

    }

}
