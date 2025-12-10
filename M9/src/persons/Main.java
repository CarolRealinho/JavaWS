package persons;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String,Person> players = PersonReader.read("src/data/players.txt");
        Map<String,Team> teams = TeamReader.read("src/data/teams.txt", players);
        System.out.println(teams);
    }
}
