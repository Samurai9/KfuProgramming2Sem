package Task4;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;

public class ChangeableCollection<T> extends AbstractCollection<T> {
    private T[] data;
    private int size;

    public ChangeableCollection(T[] data) {
        this.data = data;
        size = data.length;
    }

    @Override
    public Iterator<T> iterator() {
        MyIterator iterator = new MyIterator(data);
        return iterator;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean add(T element){
        if (size == data.length){
            data = Arrays.copyOf(data, data.length * 2 + 1);
        }
        data[size] = element;
        size++;
        return true;
    }
}
