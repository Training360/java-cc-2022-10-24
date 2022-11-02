package soccer;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

@AllArgsConstructor
public class SoccerLeagueFile {

    public static final int NUMBER_OF_HEADER_LINES = 1;

    public static final String SEPARATOR_LINE_PREFIX = "---";

    private Path path;

    public static void main(String[] args) {
        var team = new SoccerLeagueFile(Path.of("src/main/resources/football.dat")).getSmallestGoalDifference();
        System.out.println(team);
    }

    public String getSmallestGoalDifference() {
        try (var lines = Files.lines(path)) {
            return findSmallestGoalDifference(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String findSmallestGoalDifference(Stream<String> lines) {
        return lines
                .skip(NUMBER_OF_HEADER_LINES)
                .filter(SoccerLeagueFile::lineToProcess)
                .map(SoccerValues::parseLine)
                .min(Comparator.comparing(SoccerValues::getDifference))
                .orElseThrow(() -> new IllegalArgumentException("No line found"))
                .getTeam();
    }

    private static boolean lineToProcess(String s) {
        return !s.contains(SEPARATOR_LINE_PREFIX);
    }


}
