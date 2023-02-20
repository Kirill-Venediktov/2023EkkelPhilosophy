package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Generated;
import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Task9 {

    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>(
                Arrays.asList(Generated.array(String.class, new RandomGenerator.String(), 10)));
        System.out.println(strings);

    }
}
