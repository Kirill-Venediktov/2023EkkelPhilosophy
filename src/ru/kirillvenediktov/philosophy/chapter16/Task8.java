package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;

public class Task8<T> {

    private T[] array;

    public T[] initializeArray(int size) {
        array = (T[]) new Object[size];
        return array;
    }

    public static void main(String[] args) {

        Task8<String> task8 = new Task8<>();
        String[] strings = task8.initializeArray(3);
        strings[0] = "gvv";
//        strings[1] = new BerylliumSphere();

        Object[] objects = new Object[4];

//        String[] strings = (String[]) new Object[4];
        strings[0] = "ggt";

        System.out.println(Arrays.toString(strings));
    }
}
