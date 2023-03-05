package leaderboard;

public class Leader implements Comparable<Leader> {
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
    public int compareTo(Leader u) {
        Integer actual_points = getPoints();
        Integer input_points = u.getPoints();
        if (actual_points == null || input_points == null) {
            return 0;
        }
        return actual_points.compareTo(input_points);
    }

    @Override
    public String toString() {
        return "Leader{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
