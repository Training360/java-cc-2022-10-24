package weathers;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

@AllArgsConstructor
public class WeatherDataFile {

    public static final String AGGREGATE_LINE_PREFIX = "mo";

    public static final int NUMBER_OF_HEADER_LINES = 2;

    private Path path;

    public static void main(String[] args) {
        var day = new WeatherDataFile(Path.of("src/main/resources/weather.dat")).getSmallestTemperatureSpreadDay();
        System.out.println(day);
    }

    public int getSmallestTemperatureSpreadDay() {
        try (var lines = Files.lines(path)) {
           return findSmallestTemperatureSpreadDay(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int findSmallestTemperatureSpreadDay(Stream<String> lines) {
        return lines
                .skip(NUMBER_OF_HEADER_LINES)
                .filter(WeatherDataFile::lineToProcess)
                .map(TemperatureValues::parseLine)
                .min(Comparator.comparing(TemperatureValues::getDifference))
                .orElseThrow(() -> new IllegalArgumentException("No line found"))
                .getDay();
    }

    private static boolean lineToProcess(String s) {
        return !s.contains(AGGREGATE_LINE_PREFIX);
    }

}
