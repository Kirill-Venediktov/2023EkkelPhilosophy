package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.exceptions.InvalidParameterException;

import java.util.Arrays;

public class Task2 {

    public BerylliumSphere[] getBerylliumSpheresArray(int size) {
        if (size < 1) {
            throw new InvalidParameterException("Array size must be greater 1");
        }
        BerylliumSphere[] spheres = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            spheres[i] = new BerylliumSphere();
        }
        return spheres;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(Arrays.toString(task2.getBerylliumSpheresArray(4)));

    }
}
