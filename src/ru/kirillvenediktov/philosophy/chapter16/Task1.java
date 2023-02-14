package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Arrays;

public class Task1 {

    public void methodOne(BerylliumSphere[] spheres) {
        System.out.println(Arrays.toString(spheres));
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.methodOne(new BerylliumSphere[4]);
        task1.methodOne(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
    }
}
