public class Player {
    private String name;
    private String nickname;
    private int number;
    private int points;

    Player(String name, String nickname, int number, int points) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
        this.points = points;
    }

    public void grantAdditionalPoints() {
        this.points += 10;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getNumber() {
        return number;
    }

    public int getPoints() {
        return points;
    }
}
