import java.util.Iterator;

class Hash<K,V> {
    class hashElement<K1, V1> implements Comparable<hashElement<K,V>> {
        K key;
        V value;

        public hashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @SuppressWarnings("unchecked")
        public int compareTo(hashElement<K,V> O) {
            return (((Comparable<K>) this.key).compareTo(O.key));
        }
    }

    int numElements, tableSize;
    double maxLoadFactor;
    LinkedList<hashElement<K,V>>[] hashArray;

    @SuppressWarnings("unchecked")
    public Hash(int tableSize) {
        this.tableSize = tableSize;

        hashArray = (LinkedList<hashElement<K,V>>[]) new LinkedList[tableSize];

        for(int i = 0; i <tableSize; i++)
            hashArray[i] = new LinkedList<hashElement<K,V>>();

        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value) {
        if(loadFactor() > maxLoadFactor)
            resize(tableSize * 2);
        
        hashElement<K,V> he = new hashElement<K, V>(key, value);

        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;

        hashArray[hashVal].addFirst(he);

        numElements++;

        return true;
    }

    private double loadFactor() {
        return numElements/tableSize;
    }

    public boolean remove(K key, V value) {
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;

        hashArray[hashVal].removeLast();

        numElements--;

        return true;
    }
 
    @SuppressWarnings("unchecked")
    public V getValue(K key) {
        int hashVal = key.hashCode() & 0x7FFFFFFF;

        for(hashElement<K,V> he : hashArray[hashVal]) {
            if(((Comparable<K>)key).compareTo(he.key) == 0)
                return he.value;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        LinkedList<hashElement<K, V>>[] new_array = (LinkedList<hashElement<K, V>>[]) new LinkedList[newSize];

        for(int i = 0; i < newSize; i++)
            new_array[i] = new LinkedList<hashElement<K,V>>();

        for(K key : this) {
            V value = getValue(key);
            hashElement<K,V> he = new hashElement<K,V>(key, value);

            int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;

            new_array[hashVal].addFirst(he);
        }

        hashArray = new_array;
        tableSize = newSize;
    }

    @SuppressWarnings("unchecked")
    class IteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;

        public IteratorHelper() {
            keys = (T[]) Object[numElements];
            int p = 0;

            for(int i = 0; i <tableSize; i++) {
                LinkedList<hashElement<K,V>> list = hashArray[i];

                for(hashElement<K,V> h : list)
                    keys[p++] = (T)h.key;
            }
            position = 0;
        }
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            return null;
        }
    }
}