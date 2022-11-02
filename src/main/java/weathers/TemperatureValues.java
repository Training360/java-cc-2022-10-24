package weathers;

import lombok.Value;

@Value
public class TemperatureValues {

    int day;

    int min;

    int max;

    public int getDifference() {
        return max - min;
    }

    public static TemperatureValues parseLine(String line) {
        var day = Integer.parseInt(line.substring(0, 5).trim());
        var max = Integer.parseInt(line.substring(6, 8).trim());
        var min = Integer.parseInt(line.substring(12, 14).trim());
        return new TemperatureValues(day, min, max);
    }

}
