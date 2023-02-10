package ru.kirillvenediktov.philosophy.chapter15;

import java.util.ArrayList;
import java.util.List;

class FixedSizeStack<T> {

    private int index = 0;

    private List<T> storage;

    public FixedSizeStack(int size) {
        storage = new ArrayList<>(size);
    }

    public void push(T item) {
        storage.add(index++, item);
    }

    public T pop() {
        return storage.get(--index);
    }
}

public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < 10; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
