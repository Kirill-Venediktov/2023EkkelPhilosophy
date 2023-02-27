package ru.kirillvenediktov.philosophy.chapter17;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class FastTraversalLinkedList<T> extends AbstractList<T> {

    private List<T> linkedList = new LinkedList<>();

    private List<T> arrayList = new ArrayList<>();

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public T set(int index, T element) {
        T t = linkedList.set(index, element);
        refresh();
        return t;
    }

    @Override
    public void add(int index, T element) {
        linkedList.add(index, element);
        refresh();
    }

    @Override
    public T remove(int index) {
        T t = linkedList.remove(index);
        refresh();
        return t;
    }

    @Override
    public boolean remove(Object o) {
        boolean modified = linkedList.remove(o);
        if (modified) {
            refresh();
        }
        return modified;
    }

    @Override
    public boolean contains(Object o) {
        return arrayList.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return arrayList.containsAll(c);
    }

    @Override
    public boolean add(T t) {
        boolean modified = linkedList.add(t);
        refresh();
        return modified;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    public void refresh() {
        arrayList = new ArrayList<>(linkedList);
    }

    @Override
    public void clear() {
        linkedList.clear();
        refresh();
    }

    @Override
    public int indexOf(Object o) {
        return arrayList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return arrayList.lastIndexOf(o);
    }

    @Override
    public Iterator<T> iterator() {
        refresh();
        return new Iterator<T>() {

            Iterator<T> arrayListIterator = arrayList.iterator();

            Iterator<T> linkedListIterator = linkedList.iterator();

            @Override
            public boolean hasNext() {
                return arrayListIterator.hasNext();
            }

            @Override
            public T next() {
                linkedListIterator.next();
                return arrayListIterator.next();
            }

            @Override
            public void remove() {
                arrayListIterator.remove();
                linkedListIterator.remove();
            }
        };
    }

    @Override
    public ListIterator<T> listIterator() {
        refresh();
        return new ListIterator<T>() {

            ListIterator<T> arrayListListIterator = arrayList.listIterator();

            ListIterator<T> linkedListListIterator = linkedList.listIterator();

            @Override
            public boolean hasNext() {
                return arrayListListIterator.hasNext();
            }

            @Override
            public T next() {
                linkedListListIterator.next();
                return arrayListListIterator.next();
            }

            @Override
            public boolean hasPrevious() {
                return arrayListListIterator.hasPrevious();
            }

            @Override
            public T previous() {
                linkedListListIterator.previous();
                return linkedListListIterator.previous();
            }

            @Override
            public int nextIndex() {
                return arrayListListIterator.nextIndex();
            }

            @Override
            public int previousIndex() {
                return arrayListListIterator.previousIndex();
            }

            @Override
            public void remove() {
                arrayListListIterator.remove();
                linkedListListIterator.remove();
            }

            @Override
            public void set(T t) {
                arrayListListIterator.set(t);
                linkedListListIterator.set(t);
            }

            @Override
            public void add(T t) {
                arrayListListIterator.add(t);
                linkedListListIterator.add(t);
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {

            ListIterator<T> arrayListListIterator = arrayList.listIterator(index);

            ListIterator<T> linkedListListIterator = linkedList.listIterator(index);

            @Override
            public boolean hasNext() {
                return arrayListListIterator.hasNext();
            }

            @Override
            public T next() {
                linkedListListIterator.next();
                return arrayListListIterator.next();
            }

            @Override
            public boolean hasPrevious() {
                return arrayListListIterator.hasPrevious();
            }

            @Override
            public T previous() {
                linkedListListIterator.previous();
                return linkedListListIterator.previous();
            }

            @Override
            public int nextIndex() {
                return arrayListListIterator.nextIndex();
            }

            @Override
            public int previousIndex() {
                return arrayListListIterator.previousIndex();
            }

            @Override
            public void remove() {
                arrayListListIterator.remove();
                linkedListListIterator.remove();
            }

            @Override
            public void set(T t) {
                arrayListListIterator.set(t);
                linkedListListIterator.set(t);
            }

            @Override
            public void add(T t) {
                arrayListListIterator.add(t);
                linkedListListIterator.add(t);
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        linkedList.sort(c);
        refresh();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FastTraversalLinkedList<?> that = (FastTraversalLinkedList<?>) o;
        return Objects.equals(linkedList, that.linkedList) &&
                Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), linkedList, arrayList);
    }

    @Override
    public String toString() {
        return "FastTraversalLinkedList{" +
                "linkedList=" + linkedList +
                ", arrayList=" + arrayList +
                '}';
    }
}
