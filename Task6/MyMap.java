package Task6;


import java.util.*;


public class MyMap<K,V> extends AbstractMap<K,V> {
    private K[] keys;
    private V[] values;
    private int size;

    private class MyEntry<K,V> implements Entry<K,V>{

        private K key;
        private V value;

        public MyEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V result = this.value;
            this.value = value;
            return result;
        }
    }

    public MyMap(){
        this.keys = (K[]) new Object[0];
        this.values = (V[]) new Object[0];
        size = 0;
    }

    public void clear(){
        values = (V[]) new Object[0];
        keys = (K[]) new Object[0];
    }

    public boolean containsKey(Object key){
        for (int i = 0; i < size; i++) {
            if(key.equals(keys[i]));
            return true;
        }
        return false;
    }

    public boolean containsValue(Object value){
        for (int i = 0; i < size; i++) {
            if(value.equals(values[i]));
            return true;
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<MyEntry<K,V>> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            result.add(new MyEntry<K,V>(keys[i], values[i]));
        }
        return (Set)result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        return size == myMap.size &&
                Arrays.equals(keys, myMap.keys) &&
                Arrays.equals(values, myMap.values);
    }

    public V get(Object key){
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        for (int i = 0; i < size; i++){
            if (keys[i].equals(key)){
                return values[i];
            }
        }
        return defaultValue;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), size);
        result = 31 * result + Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public Set keySet(){
        Set<MyEntry<K,V>> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            result.add(new MyEntry<K,V>(keys[i], values[i]));
        }
        return result;
    }

    public V put(K key, V value){
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                values[i] = value;
                return value;
            }
        }
        if (size == keys.length){
            keys = Arrays.copyOf(keys, keys.length*2+1);
            values = Arrays.copyOf(values, values.length*2+1);
        }
        keys[size] = key;
        values[size] = value;
        size++;
        return value;
    }

    public void putAll(Map<? extends K,? extends V> m){
        Set keySet = m.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            K next = (K) iterator.next();
            put(next, m.get(next));
        }
    }

    @Override
    public V putIfAbsent(K key, V value) {
        V result = get(key);
        if (result == null) {
            result = put(key, value);
        }
        return result;
    }

    public V remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (this.keys[i].equals(key)) {
                V res = values[i];
                values[i] = null;
                return res;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        if(get(key).equals(value)){
            remove(key);
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        for (int i = 0; i < size; i++){
            if (keys[i].equals(key)){
                V result = values[i];
                values[i] = value;
                return result;
            }
        }
        return null;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                if (values[i].equals(oldValue)){
                    values[i] = newValue;
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Collection<V> values(){
        Collection<V> result = new HashSet<V>();
        for (int i = 0; i < size; i++) {
            result.add(values[i]);
        }
        return result;
    }
}
