package league;

public abstract class Player {
    private String name;
    private int id;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    private void test() {
        System.out.println("package private");
    }
}
