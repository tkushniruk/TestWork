public class Player {
    String name;
    String nickname;
    int number;
    int points;

    Player(String name, String nickname, int number, int points) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.points = points;
    }

    public void grantAdditionalPoints() {
        this.points += 10;
    }
}
