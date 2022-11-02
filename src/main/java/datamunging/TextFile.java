package datamunging;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

@AllArgsConstructor
public class TextFile {

    private Path path;

    private TextFileFormat format;

    public static void main(String[] args) {
        System.out.println(new TextFile(Path.of("src/main/resources/weather.dat"),
                new WeatherFileFormat()).getLabelForMinimalDifference());

        System.out.println(new TextFile(Path.of("src/main/resources/football.dat"),
                new SoccerLeagueFormat()).getLabelForMinimalDifference());
    }

    public String getLabelForMinimalDifference() {
        try (var lines = Files.lines(path)) {
            return findWithMinimalDifference(lines);
        } catch (IOException ioe) {
            throw new TextFileReadException("Can not read file: " + path, ioe);
        }
    }

    private String findWithMinimalDifference(Stream<String> lines) {
        return lines
                .skip(format.numberOfHeaderLines())
                .filter(format::lineToProcess)
                .map(format::parseLine)
                .min(Comparator.comparing(Values::getDifference))
                .orElseThrow(() -> new IllegalArgumentException("No line"))
                .getLabel();
    }
}
