
import com.opencsv.CSVReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Game basket = new Game("Basketball");
        Game handball = new Game("Handball");
        ArrayList<Game> games = new ArrayList<>(List.of(basket, handball));
        Utils.readAllGames(games);
        findMVP(basket,handball);
    }

    public static PlayerStats findPlayerStats(ArrayList<PlayerStats> playerStats, String name) {
        for(PlayerStats elem : playerStats) {
            if(elem.getName().equals(name)) return elem;
        }
        return null;
    }

    public static void findMVP(Game ...games) {
        ArrayList<Player> playersInAllGames = new ArrayList<>();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean isPLayerListAdded = false;
        for(Game game : games) {
            if(!isPLayerListAdded) {
                playerList.addAll(game.getTeamA().getPlayers());
                playerList.addAll(game.getTeamB().getPlayers());
                isPLayerListAdded = true;
            }
            playersInAllGames.addAll(game.getTeamA().getPlayers());
            playersInAllGames.addAll(game.getTeamB().getPlayers());
        }
        ArrayList<PlayerStats> allPlayerStats = new ArrayList<>();
        for(Player player : playerList) {
            for(Player curPlayer : playersInAllGames) {
                if(curPlayer.getName().equals(player.getName())) {
                    PlayerStats curPlayerStats = findPlayerStats(allPlayerStats, player.getName());
                    if(curPlayerStats == null) {
                        allPlayerStats.add(new PlayerStats(curPlayer.getName(), curPlayer.getPoints()));
                    }else {
                        curPlayerStats.setOverallPoints(curPlayer.getPoints() + curPlayerStats.getOverallPoints());
                    }
                }
            }
        }
        PlayerStats mvp = allPlayerStats.get(0);
        for(PlayerStats playerStats : allPlayerStats) {
           if(mvp.getOverallPoints() < playerStats.getOverallPoints()) {
               mvp = playerStats;
           }
        }

        System.out.println("\nMVP IS PLAYER WITH NAME " + mvp.getName() + " AND POINTS " + mvp.getOverallPoints());
    }
}
