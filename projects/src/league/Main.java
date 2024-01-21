package league;

public class Main {
    public static void main(String[] args) {
        Player foot1 = new FootballPlayer("beckham");
        Player base1 = new BaseballPlayer("john");
        Player soccer1 = new SoccerPlayer("tim");

        Team<FootballPlayer> footTeam1 = new Team<>("a");
        Team<FootballPlayer> footTeam2 = new Team<>("c");
        Team<FootballPlayer> footTeam3 = new Team<>("b");
        Team<BaseballPlayer> baseTeam = new Team<>("b");

        League<Team<FootballPlayer>> footLeague = new League<>();
        footLeague.addTeam(footTeam1);
        footLeague.addTeam(footTeam2);
        footLeague.addTeam(footTeam3);
        // footLeague.addTeam(baseTeam);
        footLeague.printAllTeams();
    }
}
