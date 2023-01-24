package ru.kirillvenediktov.philosophy.chapter10;

import java.util.ArrayList;
import java.util.List;

interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence {

    private List items;

    private int next = 0;

    public Sequence() {
        items = new ArrayList();
    }

    public void add(Object x) {
        items.add(x);
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) {
                i++;
            }
        }

        public Sequence getOuter() {
            return Sequence.this;
        }
    }

    private class ReverseSelector implements Selector {

        private int i = items.size() - 1;

        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }

        public Sequence getOuter() {
            return Sequence.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
        System.out.println(((SequenceSelector) selector).getOuter());

        Selector reverseSelector = sequence.reverseSelector();
        while (!reverseSelector.end()) {
            System.out.print(reverseSelector.current() + " ");
            reverseSelector.next();
        }
        System.out.println();
        System.out.println(((ReverseSelector) reverseSelector).getOuter());
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
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
