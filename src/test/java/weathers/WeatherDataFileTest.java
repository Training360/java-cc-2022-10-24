package weathers;

import org.junit.jupiter.api.Test;
import soccer.SoccerLeagueFile;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataFileTest {

    @Test
    void testGetSmallestTemperatureSpreadDay() {
        var day = new WeatherDataFile(Path.of("src/main/resources/weather.dat")).getSmallestTemperatureSpreadDay();
        assertEquals(14, day);
    }

    @Test
    void testFileNotFound() {
        var invalidFile = "xyz";
        assertThrows(IllegalStateException.class,
                () -> new SoccerLeagueFile(Path.of(invalidFile)).getSmallestGoalDifference()
        );
    }

}