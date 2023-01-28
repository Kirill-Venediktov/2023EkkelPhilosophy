package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.chapter8.RandomRodentGenerator;
import ru.kirillvenediktov.philosophy.chapter8.Rodent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence implements Collection<Rodent> {

    private static final int ARRAY_SIZE = 10;
    private static final String EXCEPTION_TEXT = "Array size less then input collection size";

    private static RandomRodentGenerator generator = new RandomRodentGenerator();

    private Rodent[] rodents = new Rodent[ARRAY_SIZE];

    public CollectionSequence() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            rodents[i] = generator.next();
        }
    }

    @Override
    public int size() {
        return rodents.length;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Rodent rodent : rodents) {
            if (rodent != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        for (Rodent rodent : rodents) {
            if (rodent == o) {
                contains = true;
            }
        }
        return contains;
    }

    @Override
    public Iterator<Rodent> iterator() {
        return new Iterator<>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < rodents.length;
            }

            @Override
            public Rodent next() {
                return rodents[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return rodents;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Rodent rodent) {
        boolean isAdded = false;
        for (int i = 0; i < rodents.length; i++) {
            if (rodents[i] == null || i == (rodents.length - 1)) {
                rodents[i] = rodent;
                isAdded = true;
            }
        }
        return isAdded;
    }

    @Override
    public boolean remove(Object o) {
        boolean isRemoved = false;
        for (int i = 0; i < rodents.length; i++) {
            if (rodents[i] == o) {
                rodents[i] = null;
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = true;
        for (Object o : c) {
            if (!contains(o)) {
                containsAll = false;
                break;
            }
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends Rodent> c) {
        if (c.size() > rodents.length) {
            throw new ArrayIndexOutOfBoundsException(EXCEPTION_TEXT);
        }
        boolean isAdded = true;
        for (Rodent rodent : c) {
            add(rodent);
        }
        return isAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() > rodents.length) {
            throw new ArrayIndexOutOfBoundsException(EXCEPTION_TEXT);
        }
        boolean isRemoved = false;
        if (containsAll(c)){
            Iterator<?> iterator = c.iterator();
            while (iterator.hasNext()) {
                remove(c);
            }
            isRemoved = true;
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetain;
        for (int i = 0; i < rodents.length; i++) {
            if (!c.contains(rodents[i])){
                rodents[i] = null;
            }
        }
        isRetain = true;
        return isRetain;
    }

    @Override
    public void clear() {
        Arrays.fill(rodents, null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionSequence rodents1 = (CollectionSequence) o;
        return Arrays.equals(rodents, rodents1.rodents);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rodents);
    }
}
