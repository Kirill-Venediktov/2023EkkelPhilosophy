package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.chapter7.A;

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long getId() {
        return id;
    }
}

class Orange {}

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple)apples.get(i)).getId();
        }
    }
}
