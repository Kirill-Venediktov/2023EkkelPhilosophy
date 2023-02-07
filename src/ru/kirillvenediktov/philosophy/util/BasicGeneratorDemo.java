package ru.kirillvenediktov.philosophy.util;

import ru.kirillvenediktov.philosophy.chapter15.CountedObject;

public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> generator = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
