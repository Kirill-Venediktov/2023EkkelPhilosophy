package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task12 {

    public static void main(String[] args) {
        List<Integer> integersOne = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integersOne.add(i);
        }
        List<Integer> integersTwo = new ArrayList<>(20);
        ListIterator listIterator = integersOne.listIterator(integersOne.size());
        while (listIterator.hasPrevious()) {
            integersTwo.add((Integer) listIterator.previous());
        }
        System.out.println(integersTwo);

    }
}
