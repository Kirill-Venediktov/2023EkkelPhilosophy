package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.CollectionData;
import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SimpleHashSet<T> extends AbstractSet<T> {

    static final int SIZE = 997;

    LinkedList<T>[] buckets = new LinkedList[SIZE];

    public SimpleHashSet() {
    }

    public SimpleHashSet(Collection<? extends T> c) {
        addAll(c);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int bucketCursor = 0;

            private int listCursor = 0;

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                while (bucketCursor < SIZE) {
                    if (buckets[bucketCursor] != null && !buckets[bucketCursor].isEmpty()) {
                        Iterator<T> lit = buckets[bucketCursor].listIterator(listCursor);
                        if (lit.hasNext()) {
                            hasNext = true;
                            break;
                        } else {
                            listCursor = 0;
                            bucketCursor++;
                        }
                    } else {
                        bucketCursor++;
                    }
                }
                return hasNext;
            }

            @Override
            public T next() {
                return buckets[bucketCursor].get(listCursor++);
            }
        };
    }

    private int getIndex(Object o) {
        return Math.abs(o.hashCode()) % SIZE;
    }

    @Override
    public boolean add(T t) {
        boolean modified = false;
        int index = getIndex(t);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<T> bucket = buckets[index];
        boolean found = false;
        ListIterator<T> it = bucket.listIterator();
        while (it.hasNext()) {
            T item = it.next();
            if (item.equals(t)) {
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(t);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean remove(Object o) {
        boolean modified = false;
        if (contains(o)) {
            modified = buckets[getIndex(o)].remove(o);
        }
        return modified;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[SIZE];
    }

    @Override
    public int size() {
        int size = 0;
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            size++;
            it.next();
        }
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleHashSet<?> that = (SimpleHashSet<?>) o;
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
        List<T> items = new ArrayList<>();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            items.add(it.next());
        }
        return "{" + items +
                "}";
    }

    public static void main(String[] args) {
        SimpleHashSet<String> strings = new SimpleHashSet<>(new CollectionData<>(new RandomGenerator.String(), 10));
        System.out.println(strings);
        strings.add("Hello!");
        strings.add("Hello!");
        System.out.println(strings);
        System.out.println(strings.size());
        strings.remove("Hello!");
        System.out.println(strings);

    }
}
