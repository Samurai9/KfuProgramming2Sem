package Task5;

import java.util.*;

public class MyNavigableSet<T> extends AbstractSet<T> implements SortedSet<T> {
    private ArrayList<T> data;
    private Comparator comparator;

    protected class MyIterator<T> implements Iterator<T> {

        private ArrayList<T> data;
        private int cursor;
        private int tempCursor;

        public MyIterator(ArrayList<T> data) {
            this.data = data;
            cursor = 0;
        }

        public MyIterator(ArrayList<T> data, int tempCursor) {
            this.data = data;
            cursor = tempCursor;
        }

        @Override
        public boolean hasNext() {
            if (cursor < data.size() && (cursor>=0)) {
                return true;
            }
            return false;
        }

        @Override
        public T next(){
            try {
                T res = data.get(cursor);
                cursor++;
                return res;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public T peek(){
            try {
                return data.get(cursor);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    protected class MyReverseIterator<T> implements Iterator<T>{
        private ArrayList<T> data;
        private int cursor;

        public MyReverseIterator(ArrayList<T> data){
            this.data = data;
            cursor = data.size()-1;
        }

        @Override
        public boolean hasNext() {
            if (cursor >= 0) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            try {
                T res = data.get(cursor);
                cursor--;
                return res;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    public MyNavigableSet(Comparator comparator) {
        data = new ArrayList<T>();
        this.comparator = comparator;
    }

    private MyNavigableSet(Comparator comparator, ArrayList data) {
        this.data = data;
        this.comparator = comparator;
    }


    /**
     * Adds the specified element to this set if it is not already present
     * @param element element to be added to this NavigableSet
     * @return true if this set did not already contain the specified element
     */
    @Override
    public boolean add(T element) {
        int counter = 0;
        MyIterator<T> iterator = new MyIterator<T>(data);
        while (iterator.hasNext()) {
            if (comparator.compare(iterator.peek(), element) == 0) {
                return false;
            }
            if (comparator.compare(iterator.peek(), element) > 0) {
                break;
            }
            counter++;
            iterator.next();
        }
        data.add(counter, element);
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this set if they're not already present
     * @param collection collection containing elements to be added to this set
     * @return true if this set changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends T> collection){
        boolean result = false;
        boolean isAdded = false;
        Iterator<? extends T> iterator = collection.iterator();
        while(iterator.hasNext()){
            isAdded = add(iterator.next());
            if (isAdded){
                result = isAdded;
            }
        }
        return result;
    }

    /**
     * Returns the least element in this set greater than or equal to the given element, or null if there is no such element
     * @param element the value to match
     * @return the least element greater than or equal to e, or null if there is no such element
     */
    public T ceiling(T element) {
        T result = element;
        boolean returnNull = true;
        for (int i = 0; i < data.size(); i++) {
            if (comparator.compare(data.get(i), element) >= 0 && comparator.compare(data.get(i), result) <= 0) {
                result = data.get(i);
                returnNull = false;
            }
        }
        if (returnNull) {
            return null;
        }
        return result;
    }

    /**
     * Removes all of the elements from this set
     */
    public void clear(){
        data = new ArrayList<T>();
    }

    /**
     * Returns the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements.
     * @return the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements
     */
    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    /**
     * Returns true if this set contains the specified element.
     * @param element - element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(Object element) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this set contains all of the elements of the specified collection.
     * @param collection collection to be checked for containment in this set
     * @return true if this set contains all of the elements of the specified collection
     */
    public boolean containsAll(Collection<?> collection){
        Iterator<?> iterator = collection.iterator();
        while(iterator.hasNext()){
            if (!this.contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an iterator over the elements in this set, in descending order.
     * @return an iterator over the elements in this set, in descending order
     */
    public Iterator<T> descendingIterator() {
        return new MyReverseIterator<T>(data);
    }

    /**
     * Returns a reverse order view of the elements contained in this set.
     * @return a reverse order view of the elements contained in this set.
     */
    public MyNavigableSet<T> descendingSet() {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (int i = data.size() - 1; i >= 0; i--) {
            arrayList.add(data.get(i));
        }
        return new MyNavigableSet(comparator, arrayList);
    }

    /**
     * Returns the first (lowest) element currently in this set.
     * @return the first (lowest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    @Override
    public T first() throws NoSuchElementException {
        if (data.size() != 0) {
            return data.get(0);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
     * @param element the value to match
     * @return the greatest element less than or equal to e, or null if there is no such element
     */
    public T floor(T element) {
        T result;
        for (int i = 0; i < data.size(); i++) {
            if(comparator.compare(data.get(i), element) == 0){
                return (T) data.get(i);
            }
            if(comparator.compare(data.get(i), element) > 0){
                return (T) data.get(i-1);
            }
        }
        return null;
    }

    /**
     * Returns the hash code value for this set.
     * @return the hash code value for this set
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data, comparator);
    }

    /**
     * Returns a view of the portion of this set whose elements are strictly less than toElement.
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly less than toElement.
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        ArrayList<T> result = new ArrayList<T>();
        for (int i = 0; i < data.size(); i++) {
            if (comparator.compare(data.get(i), toElement) < 0) {
                result.add(data.get(i));
            }
            if (comparator.compare(data.get(i), toElement) >= 0) {
                return new MyNavigableSet<T>(comparator, result);
            }
        }
        return new MyNavigableSet<T>(comparator, result);
    }

    /**
     * Returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
     * @param toElement high endpoint of the returned set
     * @param inclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     */
    public MyNavigableSet<T> headSet(T toElement, boolean inclusive) {
        ArrayList<T> result = new ArrayList<T>();
        for (int i = 0; i < data.size(); i++) {
            if (comparator.compare(data.get(i), toElement) < 0 || (inclusive && comparator.compare(data.get(i), toElement) <= 0)) {
                result.add(data.get(i));
            }
            if (comparator.compare(data.get(i), toElement) > 0 || (inclusive && comparator.compare(data.get(i), toElement) >= 0)) {
                return new MyNavigableSet<T>(comparator, result);
            }
        }
        return new MyNavigableSet<T>(comparator, result);
    }

    /**
     * Returns the least element in this set strictly greater than the given element, or null if there is no such element.
     * @param element the value to match
     * @return the least element in this set strictly greater than the given element, or null if there is no such element.
     */
    public T higher(T element) {
        for (int i = 0; i < data.size(); i++) {
            if (comparator.compare(data.get(i), element) > 0) {
                return data.get(i);
            }
        }
        return null;
    }

    /**
     * Returns an iterator over the elements in this set, in ascending order.
     * @return an iterator over the elements in this set, in ascending order.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(data);
    }

    /**
     * Returns true if this set contains no elements.
     * @return true if this set contains no elements
     */
    public boolean isEmpty(){
        if (size() != 0){
            return false;
        }
        return true;
    }

    /**
     * Returns the last (highest) element currently in this set
     * @return the last (highest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    @Override
    public T last() throws NoSuchElementException {
        if (data.size() != 0) {
            return data.get(data.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
     * @param element the value to match
     * @return the greatest element in this set strictly less than the given element, or null if there is no such element.
     */
    public T lower(T element) {
        for (int i = data.size()-1; i >= 0; i--) {
            if (comparator.compare(data.get(i), element) < 0) {
                return data.get(i);
            }
        }
        return null;
    }

    /**
     * Retrieves and removes the first (lowest) element, or returns null if this set is empty.
     * @return the first element, or null if this set is empty
     */
    public T pollFirst() {
        if (data.size() == 0) {
            return null;
        }
        T result = data.get(0);
        data.remove(0);
        return result;
    }

    /**
     * Retrieves and removes the last (highest) element, or returns null if this set is empty.
     * @return the last element, or null if this set is empty
     */
    public T pollLast() {
        if (data.size() == 0) {
            return null;
        }
        T result = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return result;
    }

    /**
     * Removes the specified element from this set if it is present
     * @param element object to be removed from this set, if present
     * @return true if this set contained the specified element
     */
    @Override
    public boolean remove(Object element) {
        return data.remove(element);
    }

    /**
     * Removes from this set all of its elements that are contained in the specified collection
     * @param collection collection containing elements to be removed from this set
     * @return true if this set changed as a result of the call
     */
    public boolean removeAll(Collection<?> collection){
        boolean result = false;
        boolean isRemove = false;
        Iterator<?> iterator = collection.iterator();
        while(iterator.hasNext()){
            isRemove = remove(iterator.next());
            if (isRemove){
                result = isRemove;
            }
        }
        return result;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection
     * @param collection collection containing elements to be retained in this set
     * @return true if this set changed as a result of the call
     */
    public boolean retainAll(Collection<?> collection){
        boolean result = false;
        for (int i = 0; i < this.size(); i++){
            if (!collection.contains(data.get(i))){
                this.remove(data.get(i));
                result = true;
            }
        }
        return result;
    }

    /**
     * Returns the number of elements in this set
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
     * @param fromElement low endpoint (inclusive) of the returned set
     * @param toElement high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        ArrayList<T> result = new ArrayList<T>();
        boolean stopFlag = false;
        for (int i = 0; i < data.size() && !stopFlag; i++) {
            if (comparator.compare(data.get(i), fromElement) >= 0) {
                if (comparator.compare(data.get(i), toElement) > 0) {
                    stopFlag = true;
                } else {
                    result.add(data.get(i));
                }
            }
        }
        return new MyNavigableSet<T>(comparator, result);
    }

    /**
     * Returns a view of the portion of this set whose elements range from fromElement to toElement.
     * @param fromElement low endpoint of the returned set
     * @param fromInclusive true if the low endpoint is to be included in the returned view
     * @param toElement high endpoint of the returned set
     * @param toInclusive true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     * @throws IllegalArgumentException if fromElement is greater than toElement; or if this set itself has a restricted range, and fromElement or toElement lies outside the bounds of the range.
     */
    public MyNavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) throws IllegalArgumentException {
        if (comparator.compare(fromElement, toElement) > 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<T> result = new ArrayList<>();
        boolean stopFlag = false;
        for (int i = 0; i < data.size() && !stopFlag; i++) {
            if ((!fromInclusive && comparator.compare(data.get(i), fromElement) > 0) || (fromInclusive && comparator.compare(data.get(i), fromElement) >= 0)) {
                if ((!toInclusive && comparator.compare(data.get(i), toElement) < 0) || (toInclusive && comparator.compare(data.get(i), toElement) <= 0)) {
                    result.add(data.get(i));
                } else {
                    stopFlag = true;
                }
            }
        }
        MyNavigableSet res = new MyNavigableSet(comparator, result);
        return res;
    }

    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     * @param fromElement low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        MyNavigableSet<T> result = new MyNavigableSet<T>(comparator);
        for (int i = 0; i < data.size(); i++) {
            if (comparator.compare(data.get(i), fromElement) > 0) {
                result.add(data.get(i));
            }
        }
        return result;
    }

    /**
     * Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.
     * @param fromElement low endpoint of the returned set
     * @param inclusive true if the low endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    public MyNavigableSet<T> tailSet(T fromElement, boolean inclusive){
        ArrayList<T> result = new ArrayList<T>();
        for (int i = 0; i < data.size(); i++) {
            if((inclusive && comparator.compare(data.get(i), fromElement) >= 0) || (!inclusive && comparator.compare(data.get(i), fromElement) > 0)){
                result.add(data.get(i));
            }
        }
        return new MyNavigableSet<T>(comparator, result);
    }

}
