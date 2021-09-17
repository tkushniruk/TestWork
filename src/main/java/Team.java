import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void setAdditionalRatingPoints() {
        for(Player player : players) {
            player.grantAdditionalPoints();
        }
    }

    public void showPlayersStats() {
        System.out.println(this.name);
        for(Player player : players) {
            System.out.println(player.name+ " " + player.nickname + " " +player.number + " " + player.points);
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
