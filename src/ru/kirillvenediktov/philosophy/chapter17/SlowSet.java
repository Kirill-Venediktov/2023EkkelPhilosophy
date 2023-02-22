package ru.kirillvenediktov.philosophy.chapter17;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class SlowSet<T> extends AbstractSet<T> {

    private List<T> values = new ArrayList<>();

    @Override
    public boolean add(T t) {
        boolean modified = false;
        if (!values.contains(t)){
            values.add(t);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean remove(Object o) {
        boolean modified = false;
        if (values.contains(o)){
            values.remove(o);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return values.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    @Override
    public int size() {
        return values.size();
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return values.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return values.removeAll(c);
    }

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return values.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return values.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        Set<? extends T> unique = new HashSet<>(c);
        for (T t : unique) {
            if (!contains(t)) {
                values.add(t);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlowSet<?> slowSet = (SlowSet<?>) o;
        return Objects.equals(values, slowSet.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), values);
    }

    @Override
    public String toString() {
        return "{" +
                values +
                '}';
    }

    public static void main(String[] args) {
        Random r = new Random();
        SlowSet<Integer> set = new SlowSet<>();
        for (int i = 0; i < 15; i++) {
            set.add(r.nextInt(10));
        }
        System.out.println(set);
        set.removeAll(set);
        System.out.println(set);
    }
}
