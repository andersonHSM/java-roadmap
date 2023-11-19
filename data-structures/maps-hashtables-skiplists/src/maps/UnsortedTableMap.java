package maps;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends CustomAbatractMap<K, V> {
    private ArrayList<CustomAbatractMap.MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++) {
            if (table.get(j).getKey().equals(key)) return j;
        }

        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean containsKey(K key) {
        int index = findIndex(key);

        return index != -1;
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) return null;

        return table.get(index).getValue();
    }

    public V put(K key, V value) {
        int index = findIndex(key);
        if (index == -1) {
            table.add(new CustomAbatractMap.MapEntry<>(key, value));
            return null;
        } else {
            return table.get(index).setValue(value);
        }
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        int size = size();
        if (index == -1) return null;

        V answer  = table.get(index).getValue();

        if (index != size -1)
            table.set(index, table.get(size -1 ));
        table.remove(size -1);

        return answer;
    }

    public Iterable<java.util.Map.Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (j == table.size()) throw new NoSuchElementException();

            return table.get(j++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class EntryIterable implements Iterable<Entry<K, V>> {

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }
}
