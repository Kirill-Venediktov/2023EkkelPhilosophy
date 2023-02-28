package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SlowMapTask36<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    private List<MapEntryTask36<K, V>> entryList = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        MapEntryTask36<K, V> newEntry = new MapEntryTask36<>(key, value);
        if (!entryList.contains(newEntry)) {
            entryList.add(newEntry);
        }
        Collections.sort(entryList);
        return oldValue;
    }

    private MapEntryTask36<K, V> getMapEntry(K key) {
        MapEntryTask36<K, V> entry = new MapEntryTask36<>(null, null);
        for (MapEntryTask36<K, V> e : entryList) {
            if (e.getKey().equals(key)) {
                entry = e;
                break;
            }
        }
        return entry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        V value = null;
        MapEntryTask36<K,V> entry = new MapEntryTask36<>((K) key, null);
        if (containsKey(key)) {
            value = entryList.get(Collections.binarySearch(entryList, entry)).getValue();
        }
        return value;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new LinkedHashSet<>(entryList);
    }

    @Override
    public Set<K> keySet() {
        return new KeySet();
    }

    private class KeySet extends AbstractSet<K> {

        @Override
        public boolean isEmpty() {
            return SlowMapTask36.this.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return containsKey(o);
        }

        @Override
        public Object[] toArray() {
            Object[] keys = new Object[entryList.size()];
            for (int i = 0; i < entryList.size(); i++) {
                keys[i] = entryList.get(i).getKey();
            }
            return keys;
        }

        @Override
        public boolean add(K k) {
            boolean modified = false;
            if (!containsKey(k)) {
                SlowMapTask36.this.put(k, null);
                modified = true;
            }
            return modified;
        }

        @Override
        public boolean remove(Object o) {
            boolean modified = false;
            if (contains(o)) {
                SlowMapTask36.this.remove(o);
                modified = true;
            }

            return modified;
        }

        @Override
        public void clear() {
            SlowMapTask36.this.clear();
        }

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {

                Iterator<MapEntryTask36<K, V>> entryIterator = entryList.iterator();

                @Override
                public boolean hasNext() {
                    return entryIterator.hasNext();
                }

                @Override
                public K next() {
                    return entryIterator.next().getKey();
                }
            };
        }

        @Override
        public int size() {
            return SlowMapTask36.this.size();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V value = null;
        if (containsKey(key)) {
            MapEntryTask36<K,V> entry = getMapEntry((K) key);
            value = entry.getValue();
            entryList.remove(entry);
        }
        return value;
    }

    @Override
    public void clear() {
        entryList.clear();
    }

    @Override
    public boolean isEmpty() {
        return entryList.isEmpty();
    }

    @Override
    public int size() {
        return entryList.size();
    }

    @Override
    public boolean containsKey(Object key) {
        boolean contains = false;
        for (MapEntryTask36<K, V> entry : entryList) {
            if (entry.getKey().equals(key)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean contains = false;
        for (MapEntryTask36<K, V> entry : entryList) {
            if (entry.getValue().equals(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object key, Object value) {
        boolean modified = false;
        MapEntry<K,V> entry = new MapEntry<>((K)key, (V)value);
        if (entryList.contains(entry)) {
            entryList.remove(entry);
            modified = true;
        }
        return modified;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (MapEntryTask36<K,V> entry : entryList) {
            values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlowMapTask36<?, ?> that = (SlowMapTask36<?, ?>) o;
        return Objects.equals(entryList, that.entryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entryList);
    }

    @Override
    public String toString() {
        return "SlowMapTask36{" +
                "entryList=" + entryList +
                '}';
    }

    public static void main(String[] args) {
        SlowMapTask36<String, String> m = new SlowMapTask36<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
