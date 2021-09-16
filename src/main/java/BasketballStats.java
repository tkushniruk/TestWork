import java.util.ArrayList;

public class BasketballStats extends GameStats{

    public int getOverallPoints(int ...points) {
        return points[0] * 2 + points[1] + points[2];
    }
}
