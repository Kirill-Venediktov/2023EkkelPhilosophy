package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;

public class Task11 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[5];
        int[] ints = new int[5];

        int a = 4;
        Integer b = 4;

        ints[0] = a;
        ints[1] = b;
        integers[0] = a;
        integers[1] = b;

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(integers));

//        ints = integers;
    }

}
