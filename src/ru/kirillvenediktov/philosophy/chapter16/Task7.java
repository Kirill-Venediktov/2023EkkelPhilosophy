package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;

public class Task7 {

    public BerylliumSphere[][][] create3DArray(int size1, int size2, int size3) {
        BerylliumSphere[][][] spheres = new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < size3; k++) {
                    spheres[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return spheres;
    }

    public static void main(String[] args) {
        Task7 task7 = new Task7();
        System.out.println(Arrays.deepToString(task7.create3DArray(2,3,2)));
    }
}
