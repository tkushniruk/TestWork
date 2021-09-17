
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
        Game basket = new Game();
        Game handball = new Game();
        Utils.readBasketballGame(basket);
        Utils.readHandballGame(handball);
        findMVP(basket,handball);
    }

    public static PlayerStats findPlayerStats(ArrayList<PlayerStats> playerStats, String name) {
        for(PlayerStats elem : playerStats) {
            if(elem.name.equals(name)) return elem;
        }
        return null;
    }

    public static void findMVP(Game ...games) {
        ArrayList<Player> playersInAllGames = new ArrayList<>();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean isPLayerListAdded = false;
        for(Game game : games) {
            if(!isPLayerListAdded) {
                playerList.addAll(game.teamA.getPlayers());
                playerList.addAll(game.teamB.getPlayers());
                isPLayerListAdded = true;
            }
            playersInAllGames.addAll(game.teamA.getPlayers());
            playersInAllGames.addAll(game.teamB.getPlayers());
        }
        for(Player player : playersInAllGames) {
            System.out.println(player.name + " " + player.points);
        }
        ArrayList<PlayerStats> allPlayerStats = new ArrayList<>();
        System.out.println(playersInAllGames.get(6).name.equals(playerList.get(0).name) + " " + playersInAllGames.get(6).name + " " + playerList.get(0).name);
        for(Player player : playerList) {
            for(Player curPlayer : playersInAllGames) {
                if(curPlayer.name.equals(player.name)) {
                    PlayerStats curPlayerStats = findPlayerStats(allPlayerStats, player.name);
                    if(curPlayerStats == null) {
                        allPlayerStats.add(new PlayerStats(curPlayer.name, curPlayer.points));
                        System.out.println(curPlayer.name + " " + curPlayer.points);
                    }else {
                        curPlayerStats.overallPoints += curPlayer.points;
                        System.out.println(curPlayer.name + " " + curPlayer.points + " " + curPlayerStats.overallPoints);
                    }
                }
            }
        }

        for(PlayerStats playerStats : allPlayerStats) {
           System.out.println(playerStats.name + " " + playerStats.overallPoints);
        }

    }
}
