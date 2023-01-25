package ru.kirillvenediktov.philosophy.chapter11;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task14 {

    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        ListIterator<Integer> iterator;
        for (int i = 0; i < 30; i++) {
            iterator = integers.listIterator(integers.size()/2);
            iterator.add(i);
        }
        System.out.println(integers);
    }
}
