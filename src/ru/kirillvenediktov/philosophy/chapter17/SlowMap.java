package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<>();

    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new LinkedHashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<K, V>(ki.next(), vi.next()));
        }
        return set;
    }

    @Override
    public Set<K> keySet() {
        return new LinkedHashSet<>(keys) {

            @Override
            public boolean removeAll(Collection<?> c) {
                Objects.requireNonNull(c);
                boolean modified = false;
                Iterator<K> iterator = iterator();
                while (iterator.hasNext()) {
                    K item = iterator.next();
                    if (c.contains(item)) {
                        iterator.remove();
                        SlowMap.this.remove(item);
                        modified = true;
                    }
                }
                return modified;
            }
        };
    }

    @Override
    public V remove(Object key) {
        V value = null;
        if (keys.contains(key)) {
            value = values.remove(keys.indexOf(key));
            keys.remove(key);
        }
        return value;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        if (keys.isEmpty() && values.isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        boolean modified = false;
        if (containsKey(key) && containsValue(value)) {
            keys.remove(key);
            values.remove(value);
            modified = true;
        }
        return modified;
    }

    @Override
    public Collection<V> values() {
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
        SlowMap<?, ?> slowMap = (SlowMap<?, ?>) o;
        return Objects.equals(keys, slowMap.keys) &&
                Objects.equals(values, slowMap.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keys, values);
    }

    @Override
    public String toString() {
        return "SlowMap{" +
                "keys=" + keys +
                ", values=" + values +
                '}';
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
