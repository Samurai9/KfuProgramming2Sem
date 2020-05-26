package Task21.ChangalbeCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {
    private T[] array;
    private int cursor;

    public MyIterator(T array[]){
        this.array = array;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if(cursor < array.length && array[cursor] != null){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        try{
            T res = array[cursor];
            cursor++;
            return res;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new NoSuchElementException();
        }
    }



}
