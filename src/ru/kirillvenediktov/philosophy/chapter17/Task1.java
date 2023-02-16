package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {

    private final static int SIZE = 10;

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Countries.names(SIZE));
        List<String> linkedList = new LinkedList<>(Countries.names(SIZE));
        System.out.println(arrayList);
        System.out.println(linkedList);

        for (int i = 0; i < 10; i++) {
            Collections.shuffle(arrayList);
            Collections.shuffle(linkedList);
            System.out.println(arrayList);
            System.out.println(linkedList);
        }
    }
}
