package mains.dayFour;

import java.util.List;

public class Range {

    public int start;

    public int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean inRange(int num) {
        return (num >= start && num <= end);
    }

}
