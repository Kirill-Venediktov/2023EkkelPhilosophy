package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.ConvertTo;
import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {

    public static void main(String[] args) {
        BerylliumSphere[] spheres = Generated.array(
                BerylliumSphere.class, new CountingGenerator.BerylliumSphere(), 10);
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = Arrays.asList(
                Generated.array(BerylliumSphere.class, new CountingGenerator.BerylliumSphere(), 5));
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = ConvertTo.primitive(Generated.array(
                Integer.class, new CountingGenerator.Integer(), 6));
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList<>(Arrays.asList(Generated.array(
                Integer.class, new CountingGenerator.Integer(), 6)));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
