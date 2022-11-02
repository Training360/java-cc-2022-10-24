package soccer;

import lombok.Value;

@Value
public class SoccerValues {

    String team;

    int min;

    int max;

    public int getDifference() {
        return Math.abs(min - max);
    }

    public static SoccerValues parseLine(String line) {
        var team = line.substring(7, 23).trim();
        var max = Integer.parseInt(line.substring(43, 46).trim());
        var min = Integer.parseInt(line.substring(50, 53).trim());
        return new SoccerValues(team, max, min);
    }
}
