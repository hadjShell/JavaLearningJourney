package league;

public class FootballPlayer extends Player {

    public FootballPlayer(String name) {
        super(name);
    }

    public FootballPlayer(String name, int id) {
        super(name, id);
    }

    public void test() {
        System.out.println(getId());
    }
}
