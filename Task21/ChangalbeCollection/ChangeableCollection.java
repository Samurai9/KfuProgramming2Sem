package Task21.ChangalbeCollection;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ChangeableCollection<T> extends AbstractCollection<T> {
    private T[] data;
    private int size;

    public ChangeableCollection(T[] data) {
        this.data = data;
        size = data.length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeableCollection<?> that = (ChangeableCollection<?>) o;
        return size == that.size &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
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

    public boolean remove(int index){
        if(size == 0 || index > size){
            return false;
        }
        for (int i = index; i < data.length-1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        return true;
    }

    /*public boolean removeFirst(){
        if(size == 0){
            return false;
        }
        data = Arrays.copyOfRange(data,1, size);
        return true;
    }

    public boolean removeLast(){
        if(size == 0){
            return false;
        }
        size--;
        return true;
    }*/
}
