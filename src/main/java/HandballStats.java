import java.util.ArrayList;

public class HandballStats extends GameStats{
    @Override
    public int getOverallPoints(int ...points) {
        return points[0] * 2 - points[1] * 1;
    }
}
