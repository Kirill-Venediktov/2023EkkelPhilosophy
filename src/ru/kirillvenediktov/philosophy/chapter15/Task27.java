package ru.kirillvenediktov.philosophy.chapter15;

import java.util.ArrayList;
import java.util.List;

public class Task27 {

    public static void main(String[] args) {
//        List<Number> numbers = new ArrayList<Integer>();

        List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(5);
//        numbers.add(4.5);
        numbers.add(null);
    }
}
