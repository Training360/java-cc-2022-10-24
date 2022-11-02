package datamunging;

public class WeatherFileFormat implements TextFileFormat {

    @Override
    public Values parseLine(String line) {
        var label = Integer.parseInt(line.substring(0, 5).trim());
        var max = Integer.parseInt(line.substring(6, 8).trim());
        var min = Integer.parseInt(line.substring(12, 14).trim());
        return new Temperatures(label, min, max);
    }

    @Override
    public boolean lineToProcess(String s) {
        return !s.contains("mo");
    }

    @Override
    public int numberOfHeaderLines() {
        return 2;
    }
}
