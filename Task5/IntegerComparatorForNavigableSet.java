package Task5;

import java.util.Comparator;

public class IntegerComparatorForNavigableSet<T> implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
