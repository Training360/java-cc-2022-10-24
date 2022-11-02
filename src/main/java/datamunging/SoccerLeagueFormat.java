package datamunging;

public class SoccerLeagueFormat implements TextFileFormat {

    @Override
    public Values parseLine(String line) {
        var label = line.substring(7, 23).trim();
        var max = Integer.parseInt(line.substring(43, 46).trim());
        var min = Integer.parseInt(line.substring(50, 53).trim());
        return new TeamResults(label, max, min);
    }

    @Override
    public boolean lineToProcess(String s) {
        return !s.contains("---");
    }

    @Override
    public int numberOfHeaderLines() {
        return 1;
    }
}
