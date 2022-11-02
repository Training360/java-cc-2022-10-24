package datamunging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoccerLeagueFormatTest {

    @Test
    void parseLine() {
        var line = "    7. West_Ham        38    15   8  15    48  -  57    53";
        var format = new SoccerLeagueFormat();
        var value = format.parseLine(line);
        assertEquals("West_Ham", value.getLabel());
        assertEquals(9, value.getDifference());
    }

    @Test
    void lineToProcess() {
        var line = "    7. West_Ham        38    15   8  15    48  -  57    53";
        var format = new SoccerLeagueFormat();
        assertTrue(format.lineToProcess(line));
    }

    @Test
    void lineNotToProcess() {
        var line = "   -------------------------------------------------------";
        var format = new SoccerLeagueFormat();
        assertFalse(format.lineToProcess(line));
    }
}