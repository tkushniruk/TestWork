import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static void readBasketballGame(Game game) {
        String fileName = "basket.csv";
        BasketballStats basketballStats = new BasketballStats();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> data = reader.readAll();
            Team teamA = new Team("Team A");
            Team teamB = new Team("Team B");
            int pointsA = 0;
            int pointsB = 0;
            for(int i = 0; i < data.size(); i++ ) {
                String[] elem = data.get(i)[0].split(";");
                System.out.println();
                int ratingPoints = basketballStats.getOverallPoints(Integer.parseInt(elem[4]),Integer.parseInt(elem[5]),Integer.parseInt(elem[6]));

                Player player = new Player(elem[0],elem[1],Integer.parseInt(elem[2]),ratingPoints);
                if(elem[3].equals("Team A")) {
                    teamA.addPlayer(player);
                    pointsA += Integer.parseInt(elem[5]);
                }else if(elem[3].equals("Team B")) {
                    teamB.addPlayer(player);
                    pointsB += Integer.parseInt(elem[5]);
                }
            }
            game.teamA = teamA;
            game.teamB = teamB;
            if(pointsA > pointsB) {
                teamA.setAdditionalRatingPoints();
                game.winner = teamA;
            }else {
                teamB.setAdditionalRatingPoints();
                game.winner = teamB;
            }
            teamA.showPlayersStats();
            teamB.showPlayersStats();
        }catch(CsvException ex) {
            System.out.println(ex.getMessage());
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void readHandballGame(Game game) {
        String fileName = "handball.csv";
        HandballStats handballStats = new HandballStats();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> data = reader.readAll();
            Team teamA = new Team("Team A");
            Team teamB = new Team("Team B");
            int pointsA = 0;
            int pointsB = 0;
            for(int i = 0; i < data.size(); i++ ) {
                String[] elem = data.get(i)[0].split(";");
                System.out.println();
                int ratingPoints = handballStats.getOverallPoints(Integer.parseInt(elem[4]),Integer.parseInt(elem[5]));

                Player player = new Player(elem[0],elem[1],Integer.parseInt(elem[2]),ratingPoints);
                if(elem[3].equals("Team A")) {
                    teamA.addPlayer(player);
                    pointsA += Integer.parseInt(elem[5]);
                }else if(elem[3].equals("Team B")) {
                    teamB.addPlayer(player);
                    pointsB += Integer.parseInt(elem[5]);
                }
            }
            game.teamA = teamA;
            game.teamB = teamB;
            if(pointsA > pointsB) {
                teamA.setAdditionalRatingPoints();
                game.winner = teamA;
            }else {
                teamB.setAdditionalRatingPoints();
                game.winner = teamB;
            }
            teamA.showPlayersStats();
            teamB.showPlayersStats();
            System.out.println(game.winner.getName());
        }catch(CsvException ex) {
            System.out.println(ex.getMessage());
        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
