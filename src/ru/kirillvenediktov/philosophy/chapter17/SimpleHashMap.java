package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        int count = 0;
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            count++;
            if (iPair.getKey().equals(key)) {
                System.out.println("Collision. key = " + key + " value = " + value + " bucket = " + bucket);
                System.out.println("iterations number: " + count);
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
            }
        }
        if (!found) {
            if (buckets[index].size() != 0) {
                System.out.println("Collision. key = " + key + " value = " + value + " bucket = " + bucket);
            }
            buckets[index].add(pair);
        }
        return oldValue;
    }

    private int getIndex(Object o) {
        return Math.abs(o.hashCode()) % SIZE;
    }

    @Override
    public V get(Object key) {
        V value = null;
        MapEntry<K,V> mapEntry = getMapEntry(key);
        if (mapEntry != null) {
            value = mapEntry.getValue();
        }
        return value;
    }

    private MapEntry<K,V> getMapEntry(Object key) {
        MapEntry<K,V> mapEntry = null;
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (MapEntry<K, V> iPair : buckets[index]) {
                if (iPair.getKey().equals(key)) {
                    mapEntry = iPair;
                    break;
                }
            }
        }
        return mapEntry;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[SIZE];
    }

    @Override
    public V remove(Object key) {
        V value = null;
        MapEntry<K,V> mapEntry = getMapEntry(key);
        if (mapEntry != null) {
            value = mapEntry.getValue();
            buckets[getIndex(key)].remove(mapEntry);
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
        for (Entry<K,V> entry : entrySet()) {
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
        for (Entry<K,V> entry : entrySet()) {
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
        SimpleHashMap<?, ?> that = (SimpleHashMap<?, ?>) o;
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
        return "{" + Arrays.toString(buckets) + '}';
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
        m.remove("ERITREA");
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}
