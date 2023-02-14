package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;

public class Task6 {

    public BerylliumSphere[][] create2DArray(int size1, int size2) {
        BerylliumSphere[][] spheres = new BerylliumSphere[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                spheres[i][j] = new BerylliumSphere();
            }
        }
        return spheres;
    }

    public static void main(String[] args) {
        Task6 task6 = new Task6();
        System.out.println(Arrays.deepToString(task6.create2DArray(2,3)));
    }
}
