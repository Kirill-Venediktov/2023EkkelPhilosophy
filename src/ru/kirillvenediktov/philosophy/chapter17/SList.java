package ru.kirillvenediktov.philosophy.chapter17;

import java.util.NoSuchElementException;

class Link<T> {

    private Link<T> next;

    private T item;

    public Link(T item) {
        this.item = item;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class SList<T> {

    private Link<T> first;

    private int size;

    public SListIterator sListIterator() {
        return new SListIterator();
    }

    @Override
    public String toString() {
        return "SList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    private class SListIterator {

        private Link<T> prev;

        private Link<T> lastReturned;

        private Link<T> next;

        private int nextIndex;

        public SListIterator() {
            this.nextIndex = 0;
            this.next = first;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (lastReturned != null) {
                prev = lastReturned;
            }
            lastReturned = next;
            next = next.getNext();
            nextIndex++;
            return lastReturned.getItem();
        }

        public int nextIndex() {
            return nextIndex;
        }

        public void set(T t) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.setItem(t);
        }


        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (prev != null) {
                prev.setNext(next);
            }
            nextIndex--;
            size--;
            lastReturned = null;
        }

        public void add(T t) {
            Link<T> newLink = new Link<>(t);
            if (lastReturned == null && next == null) {
                if (first == null) {
                    first = newLink;
                }
                if (prev != null) {
                    prev.setNext(newLink);
                }
                next = newLink;
            } else if (lastReturned == null) {
                if (prev != null) {
                    prev.setNext(newLink);
                } else {
                    first = newLink;
                }
                newLink.setNext(next);
                next = newLink;
            } else {
                newLink.setNext(next);
                lastReturned.setNext(newLink);
            }
            size++;
        }
    }

    public static void main(String[] args) {
        SList<String> test = new SList<>();
        SList<String>.SListIterator iterator = test.sListIterator();
        iterator.add("aaa");
        for (int i = 0; i < 5; i++) {
            iterator.add("bbb");
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------");
        iterator = test.sListIterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();

        iterator = test.sListIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("----------");

        iterator = test.sListIterator();
        iterator.next();
        iterator.next();
        iterator.set("QWERTY");
        iterator = test.sListIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
