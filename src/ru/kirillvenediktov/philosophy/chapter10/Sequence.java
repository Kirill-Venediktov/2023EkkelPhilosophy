package ru.kirillvenediktov.philosophy.chapter10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Sequence {

    private List items;

    public Sequence() {
        items = new ArrayList();
    }

    public void add(Object x) {
        items.add(x);
    }

    public Iterator iterator() {
        return items.iterator();
    }

    public ListIterator reverseIterator() {
        return items.listIterator(items.size());
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        ListIterator listIterator = sequence.reverseIterator();
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}

class Task2 {

    String s;

    public Task2(int i) {
        this.s = "Строка с номером " + i;
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(new Task2(i));
        }
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
