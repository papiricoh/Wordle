package leaderboard;

public class Leader {
    private String name;
    private int points;

    public Leader(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
