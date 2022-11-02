package datamunging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherFileFormatTest {

    @Test
    void parseLine() {
        var line = "   7  73    57    65          53.0       0.00 RF      050  9.5 050  17  5.3  90 48 1021.8";
        var format = new WeatherFileFormat();
        var value = format.parseLine(line);
        assertEquals("7", value.getLabel());
        assertEquals(16, value.getDifference());
    }

    @Test
    void lineToProcess() {
        var line = "   7  73    57    65          53.0       0.00 RF      050  9.5 050  17  5.3  90 48 1021.8";
        var format = new WeatherFileFormat();
        assertTrue(format.lineToProcess(line));
    }

    @Test
    void lineNotToProcess() {
        var line = "  mo  82.9  60.5  71.7    16  58.8       0.00              6.9          5.3";
        var format = new WeatherFileFormat();
        assertFalse(format.lineToProcess(line));
    }
}