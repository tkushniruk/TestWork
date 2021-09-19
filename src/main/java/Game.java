public class Game {
    private String name;
    private Team teamA;
    private Team teamB;
    private Team winner;
    private GameStats stats;

    Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public Team getWinner() {
        return winner;
    }

    public GameStats getStats() {
        return stats;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
