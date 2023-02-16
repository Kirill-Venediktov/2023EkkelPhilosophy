package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task3 {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> forMultipleAdding = new HashSet<>(Countries.capitals(10).keySet());

        for (int i = 0; i < 10; i++) {
            hashSet.addAll(forMultipleAdding);
            linkedHashSet.addAll(forMultipleAdding);
            treeSet.addAll(forMultipleAdding);
        }

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }
}
