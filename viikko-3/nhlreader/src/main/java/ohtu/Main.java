package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        ArrayList<Player> pelaajat = Arrays.stream(players).filter(x -> x.getNationality().equals("FIN")).collect(Collectors.toCollection(ArrayList::new));
        pelaajat.sort(Comparator.comparing(Player::getPoints).reversed());
        System.out.println("Oliot:");
        for (Player player : pelaajat) {
            System.out.println(player.getName() + " " + player.getTeam() + " " + player.getPointsString());
        }
    }

}