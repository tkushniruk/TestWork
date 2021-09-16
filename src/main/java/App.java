
import com.opencsv.CSVReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Game basket = new Game();
        Game handball = new Game();
        Utils.readBasketballGame(basket);
        Utils.readHandballGame(handball);
    }

    public static void findMVP(Game ...games) {
        for(Game game : games) {

        }
    }
}
