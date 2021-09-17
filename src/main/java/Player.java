public class Player {
    String name;
    String nickname;
    int number;
    int points;
    int overallPoints;

    Player(String name, String nickname, int number, int points) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.points = points;
    }

    public void grantAdditionalPoints() {
        this.points += 10;
    }
    public void setOverallPoints(int overallPoints) { this.overallPoints = overallPoints; }
}
