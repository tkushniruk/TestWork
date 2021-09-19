public class PlayerStats {
    private String name;
    private int overallPoints;

    PlayerStats(String name, int points) {
        this.name = name;
        this.overallPoints = points;
    }

    public int getOverallPoints() {
        return overallPoints;
    }

    public void setOverallPoints(int overallPoints) {
        this.overallPoints = overallPoints;
    }

    public String getName() {
        return name;
    }
}
