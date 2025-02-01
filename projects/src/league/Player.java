package league;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void test() {
        System.out.println("package private");
    }
}
