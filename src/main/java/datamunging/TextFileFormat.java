package datamunging;

public interface TextFileFormat {
    Values parseLine(String s);

    boolean lineToProcess(String s);

    int numberOfHeaderLines();
}
