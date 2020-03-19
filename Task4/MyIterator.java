package Task4;

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
        if(cursor < array.length){
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
