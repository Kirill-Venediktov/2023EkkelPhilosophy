package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task23 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers, new IntegerReverseComparator());
        System.out.println("sorted = " + Arrays.toString(integers));
    }
}

class IntegerReverseComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
    }
}
