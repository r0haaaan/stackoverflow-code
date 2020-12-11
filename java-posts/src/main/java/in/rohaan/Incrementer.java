package in.rohaan;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Code for https://stackoverflow.com/questions/65239851/
 */ 
public class Incrementer implements Iterable<Integer> {
    private Integer current;
    private Integer step;
    private Integer start;
    private Integer end;

    public Incrementer(Integer start, Integer end) {
        this.start = start;
        this.end = end;
        this.step = start > end ? -1 : 1;
        this.current = null;
    }

    public Incrementer by(Integer offset) {
        this.step = offset;
        if ((offset < 0 && this.start < this.end) ||
                (offset > 0 && this.start > this.end)) {
            swapStartAndEnd();
        }
        return this;
    }

    private void swapStartAndEnd() {
        Integer temp = this.start;
        this.start = this.end;
        this.end = temp;
    }

    public static Incrementer in(Integer start, Integer end) {
        return new Incrementer(start, end);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                if (current == null) {
                    return true;
                }
                return isNextValueWithinBounds(getNextValue(current));
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                if (current == null) {
                    current = start;
                } else {
                    current = getNextValue(current);
                }

                return current;
            }

            private boolean isNextValueWithinBounds(Integer value) {
                if (start > end) {
                    return value >= end;
                } else {
                    return value <= end;
                }
            }

            private Integer getNextValue(Integer value) {
                return value + step;
            }
        };
    }
}
