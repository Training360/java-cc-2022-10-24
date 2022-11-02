package soccer;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SoccerLeagueFileTest {

    @Test
    void testGetSmallestGoalDifference() {
        var team = new SoccerLeagueFile(Path.of("src/main/resources/football.dat")).getSmallestGoalDifference();
        assertEquals("Aston_Villa", team);
    }

    @Test
    void testFileNotFound() {
        var invalidFile = "xyz";
        assertThrows(IllegalStateException.class,
                () -> new SoccerLeagueFile(Path.of(invalidFile)).getSmallestGoalDifference()
        );
    }
}