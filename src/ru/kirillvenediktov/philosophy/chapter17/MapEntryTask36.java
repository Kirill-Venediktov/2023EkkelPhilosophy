package ru.kirillvenediktov.philosophy.chapter17;

import java.util.Map;
import java.util.Objects;

public class MapEntryTask36<K extends Comparable<K>, V> implements Map.Entry<K, V>, Comparable<MapEntryTask36<K,V>> {

    private K key;

    private V value;

    private MapEntryTask36<K,V> next;

    public MapEntryTask36(K key, V value) {
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
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public MapEntryTask36<K, V> getNext() {
        return next;
    }

    public void setNext(MapEntryTask36<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntryTask36<?, ?> mapEntry = (MapEntryTask36<?, ?>) o;
        return Objects.equals(key, mapEntry.key) &&
                Objects.equals(value, mapEntry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int compareTo(MapEntryTask36<K, V> o) {
        return this.getKey().compareTo(o.getKey());
    }
}
