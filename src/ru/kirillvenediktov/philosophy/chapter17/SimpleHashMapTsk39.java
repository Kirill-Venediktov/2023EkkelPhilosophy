package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimpleHashMapTsk39<K, V> extends AbstractMap<K, V> {

    private static final float loadFactor = 0.75f;

    static final int SIZE = 997;

    private int actualMaxSize = SIZE;

    public static final int MAP_ENTRY_INDEX = 0;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        if (!bucket.isEmpty()) {
            MapEntry<K, V> current = bucket.get(MAP_ENTRY_INDEX);
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(pair);
        } else {
            bucket.add(pair);
        }
        rehash();
        return oldValue;
    }


    public int getNumberOfNotNullBuckets() {
        int count = 0;
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null && !bucket.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private int getNewActualSize(int current) {
        while (true){
            boolean isPrime = true;
            for (int i = 2; i < current; i++) {
                if (current % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime) {
                current++;
            } else {
                break;
            }
        }
        return current;
    }

    private void rehash() {
        if (getNumberOfNotNullBuckets() > loadFactor * actualMaxSize) {
            actualMaxSize = getNewActualSize(actualMaxSize * 2);
            Set<Entry<K, V>> entries = entrySet();
            buckets = new LinkedList[actualMaxSize];
            for (Entry<K, V> entry : entries) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private int getIndex(Object o) {
        return Math.abs(o.hashCode()) % actualMaxSize;
    }

    @Override
    public V get(Object key) {
        V value = null;
        MapEntry<K, V> mapEntry = getMapEntry(key);
        if (mapEntry != null) {
            value = mapEntry.getValue();
        }
        return value;
    }

    private MapEntry<K, V> getMapEntry(Object key) {
        MapEntry<K, V> mapEntry = null;
        int index = getIndex(key);
        if (buckets[index] != null && !buckets[index].isEmpty()) {
            MapEntry<K, V> current = buckets[index].get(MAP_ENTRY_INDEX);
            while (!current.getKey().equals(key) && current.getNext() != null) {
                current = current.getNext();
            }
            if (current.getKey().equals(key)) {
                mapEntry = current;
            }
        }
        return mapEntry;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null && !bucket.isEmpty()) {
                MapEntry<K, V> current = bucket.get(MAP_ENTRY_INDEX);
                set.add(current);
                while (current.getNext() != null) {
                    current = current.getNext();
                    set.add(current);
                }
            }
        }
        return set;
    }

    @Override
    public void clear() {
        actualMaxSize = SIZE;
        buckets = new LinkedList[SIZE];
    }

    @Override
    public V remove(Object key) {
        V value = null;
        MapEntry<K, V> mapEntry = getMapEntry(key);
        if (mapEntry != null) {
            value = mapEntry.getValue();
            LinkedList<MapEntry<K, V>> bucket = buckets[getIndex(mapEntry.getKey())];
            MapEntry<K, V> current = bucket.get(MAP_ENTRY_INDEX);
            if (current.equals(mapEntry)) {
                if (current.getNext() != null) {
                    bucket.set(MAP_ENTRY_INDEX, current.getNext());
                } else {
                    bucket.clear();
                }
            } else {
                MapEntry<K, V> previous = current;
                while (!current.equals(mapEntry)) {
                    previous = current;
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    previous.setNext(current.getNext());
                } else {
                    previous.setNext(null);
                }
            }
        }
        return value;
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        boolean contains = false;
        for (Entry<K, V> entry : entrySet()) {
            if (entry.getValue().equals(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean contains = false;
        for (Entry<K, V> entry : entrySet()) {
            if (entry.getKey().equals(key)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleHashMapTsk39<?, ?> that = (SimpleHashMapTsk39<?, ?>) o;
        return Arrays.equals(buckets, that.buckets);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(buckets);
        return result;
    }

    @Override
    public String toString() {
        return "{" + entrySet() + '}';
    }

    public static void main(String[] args) {
        SimpleHashMapTsk39<String, String> m = new SimpleHashMapTsk39<>();
        RandomGenerator.String gen = new RandomGenerator.String();
        for (int i = 0; i < 997; i++) {
            m.put(gen.next(), gen.next());
        }
        System.out.println(m);
        System.out.println("not null buckets: " + m.getNumberOfNotNullBuckets());
        System.out.println(m.size());
        for (int i = 0; i < 200; i++) {
            m.put(gen.next(), gen.next());
        }
        System.out.println("not null buckets: " + m.getNumberOfNotNullBuckets());
        System.out.println(m.size());

    }
}
