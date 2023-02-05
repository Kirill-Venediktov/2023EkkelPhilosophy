package ru.kirillvenediktov.philosophy.chapter14.factory;

import ru.kirillvenediktov.philosophy.util.TypeCounter;

import java.util.ArrayList;
import java.util.List;

public class FactoryCount {

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Part.class);
        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            parts.add(Part.createRandom());
    }
        for (Part part : parts) {
            typeCounter.count(part);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
