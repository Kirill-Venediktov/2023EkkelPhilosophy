package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;
import java.util.Objects;

public class Task19 implements Comparable<Task19> {

    private int anInt;

    public Task19(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task19 task19 = (Task19) o;
        return anInt == task19.anInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt);
    }

    @Override
    public int compareTo(Task19 o) {
        return Integer.compare(anInt, o.anInt);
    }

    @Override
    public String toString() {
        return "Task19{" +
                "anInt=" + anInt +
                '}';
    }

    public static void main(String[] args) {
        int size = 5;
        Task19[] t1 = new Task19[size];
        Task19[] t2 = new Task19[size];

        for (int i = 0; i < size; i++) {
            t1[i] = new Task19(i);
            t2[i] = new Task19(i);
        }
        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
        System.out.println(Arrays.equals(t1, t2));

        Task19 task19 = new Task19(size -1);
        int location = Arrays.binarySearch(t1, task19);
        System.out.println("Location of " + task19 + " is "
                + location + ", t1[" + location + "] = " + t1[location]);

    }

}
