package Task4;

import java.util.*;

public class UnchangeableCollection<T> extends AbstractCollection {
    private Object[] data;

    public UnchangeableCollection(T[] data){
        this.data = data;
    }


    public UnchangeableCollection(Collection <? extends T> collection){
        data = collection.toArray();
    }

    @Override
    public Iterator iterator() {
        MyIterator iterator = new MyIterator(data);
        return iterator;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnchangeableCollection<?> that = (UnchangeableCollection<?>) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

}


