package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.Arrays;

public class Task12 {

    public static void main(String[] args) {

        Generator<Double> generator = new CountingGenerator.Double();

        Double[] doubles = new Double[5];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = generator.next();
        }

        System.out.println(Arrays.toString(doubles));
    }
}
