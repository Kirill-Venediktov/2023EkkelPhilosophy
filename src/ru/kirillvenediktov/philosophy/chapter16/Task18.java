package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generated;

import java.util.Arrays;

public class Task18 {

    public static void main(String[] args) {
        BerylliumSphere[] b1 = Generated.array(BerylliumSphere.class, new CountingGenerator.BerylliumSphere(), 10);
        BerylliumSphere[] b2 = new BerylliumSphere[7];
        System.arraycopy(b1, 0, b2, 0, b2.length);
        System.out.println("b1 = " + Arrays.toString(b1));
        System.out.println("b2 = " + Arrays.toString(b2));
    }
}
