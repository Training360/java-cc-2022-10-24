package datamunging;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {

    @Test
    void testGetLabelForMinimalDifferenceWithWeathers() {
        var value = new TextFile(Path.of("src/main/resources/weather.dat"),
                new WeatherFileFormat()).getLabelForMinimalDifference();
        assertEquals("14", value);
    }

    @Test
    void testGetLabelForMinimalDifferenceWithTeams() {
        var value = new TextFile(Path.of("src/main/resources/football.dat"),
                new SoccerLeagueFormat()).getLabelForMinimalDifference();
        assertEquals("Aston_Villa", value);
    }

    @Test
    void testFileNotFound() {
        var invalidPath = "xyz";
        assertThrows(TextFileReadException.class,
                () -> new TextFile(Path.of(invalidPath),
                    new SoccerLeagueFormat()).getLabelForMinimalDifference());
    }
}