package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;
import java.util.Objects;

public class Task20 {

    private int anInt;

    public Task20(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task20 task19 = (Task20) o;
        return anInt == task19.anInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt);
    }

    @Override
    public String toString() {
        return "Task19{" +
                "anInt=" + anInt +
                '}';
    }

    public static void main(String[] args) {
        int size1 = 3;
        int size2 = 2;
        int size3 = 3;
        Task20[][][] t1 = new Task20[size1][size2][size3];
        Task20[][][] t2 = new Task20[size1][size2][size3];

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < size3; k++) {
                    t1[i][j][k] = new Task20(i);
                    t2[i][j][k] = new Task20(i);
                }
            }
        }
        System.out.println(Arrays.deepToString(t1));
        System.out.println(Arrays.deepToString(t2));
        System.out.println(Arrays.deepEquals(t1, t2));

    }
}
