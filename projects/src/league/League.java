package league;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private ArrayList<T> teams = new ArrayList<>();

    public void addTeam(T t) {
        if(!teams.contains(t))
            teams.add(t);
    }

    public void printAllTeams() {
        Collections.sort(teams);
        for (T team : teams) {
            System.out.println(team.getName());
        }
    }
}
