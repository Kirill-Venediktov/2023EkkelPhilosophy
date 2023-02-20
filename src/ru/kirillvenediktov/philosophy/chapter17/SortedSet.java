package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.exceptions.InvalidParameterException;
import ru.kirillvenediktov.philosophy.util.Generator;
import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class SortedSet<T> extends LinkedList<T> {

    private final Comparator<? super T> comparator;

    public SortedSet() {
        this.comparator = null;
    }

    public SortedSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<? super T> comparator() {
        return comparator;
    }

    @SuppressWarnings("unchecked")
    final int compare(Object t1, Object t2) {
        return comparator == null ? ((Comparable<? super T>) t1).compareTo((T) t2)
                : comparator.compare((T) t1, (T) t2);
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < size(); i++) {
            int compRes = compare(t, get(i));
            if (compRes < 0) {
                add(i, t);
                return true;
            } else if (compRes == 0) {
                return false;
            }
        }
        return super.add(t);
    }

    public T first() {
        return super.getFirst();
    }

    public T last() {
        return super.getLast();
    }

    public SortedSet<T> subSet(T fromElement, T toElement) {
        if (!contains(fromElement) || !contains(toElement) || compare(fromElement, toElement) >= 0) {
            throw new InvalidParameterException("invalid arguments");
        }
        SortedSet<T> subset = new SortedSet<>();
        for (int i = 0; i < size(); i++) {
            T element = get(i);
            if (compare(element, fromElement) >= 0) {
                if (compare(toElement, element) <= 0) {
                    break;
                }
                subset.add(element);
            }
        }
        return subset;
    }

    public SortedSet<T> headSet(T toElement) {
        if (!contains(toElement)) {
            throw new InvalidParameterException("invalid argument");
        }
        SortedSet<T> headSet = new SortedSet<>();
        for (int i = 0; i < size(); i++) {
            T element = get(i);
            if (compare(toElement, element) > 0) {
                headSet.add(element);
            } else {
                break;
            }
        }
        return headSet;
    }

    public SortedSet<T> tailSet(T fromElement) {
        if (!contains(fromElement)) {
            throw new InvalidParameterException("invalid argument");
        }
        SortedSet<T> tailSet = new SortedSet<>();
        for (int i = 0; i < size(); i++) {
            T element = get(i);
            if (compare(element, fromElement) >= 0) {
                tailSet.add(element);
            }
        }
        return tailSet;
    }

    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new SortedSet<>();
        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            sortedSet.add(random.nextInt(25));
        }

        System.out.println(sortedSet);

        SortedSet<String> strings = new SortedSet<>();
        Generator<String> stringGenerator = new RandomGenerator.String();
        for (int i = 0; i < 25; i++) {
            strings.add(stringGenerator.next());
        }
        System.out.println(strings);

        System.out.println("---------");

        SortedSet<Integer> integers = new SortedSet<>();
        for (int i = 25; i > 0; i--) {
            integers.add(i);
        }
        System.out.println(integers);

        System.out.println(integers.first());
        System.out.println(integers.last());
        System.out.println(integers.headSet(16));
        System.out.println(integers.tailSet(14));
        System.out.println(integers.subSet(3, 7));

    }
}
