package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generated;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Task18 {

    public static void main(String[] args) {
        BerylliumSphere[] b1 = Generated.array(BerylliumSphere.class, new CountingGenerator.BerylliumSphere(), 10);
        BerylliumSphere[] b2 = new BerylliumSphere[7];
        System.arraycopy(b1, 0, b2, 0, b2.length);
        System.out.println("b1 = " + Arrays.toString(b1));
        System.out.println("b2 = " + Arrays.toString(b2));
        Arrays.sort(b1);
        System.out.println("sorted: " + Arrays.toString(b1));
        Arrays.sort(b1, new BerylliumSphereComparator());
        System.out.println("reverse sorting: " + Arrays.toString(b1));
    }
}

class BerylliumSphereComparator implements Comparator<BerylliumSphere> {

    @Override
    public int compare(BerylliumSphere o1, BerylliumSphere o2) {
        return (Long.compare(o2.getId(), o1.getId()));
    }
}
