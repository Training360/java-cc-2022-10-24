package datamunging;

import lombok.Value;

@Value
public class Temperatures implements Values {

    int day;

    int min;

    int max;

    @Override
    public int getDifference() {
        return max - min;
    }

    @Override
    public String getLabel() {
        return Integer.toString(day);
    }
}
