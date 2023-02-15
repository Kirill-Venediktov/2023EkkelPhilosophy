package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.Generated;
import ru.kirillvenediktov.philosophy.util.Generator;
import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.Arrays;

public class Task22 {

    private static Generator<Integer> generator = new RandomGenerator.Integer(20);

    public int findInt(Integer[] integers, int forSearch) {
        int found;
        while (true) {
            int location = Arrays.binarySearch(integers, forSearch);
            if (location >= 0) {
                System.out.println("Location of " + forSearch + " is "
                        + location + ", integers[" + location + "] = " + integers[location]);
                found = location;
                break;
            }
        }
        return found;
    }

    public int findInt(Integer[] integers) {
        int found;
        while (true) {
            int forSearch = generator.next();
            int location = Arrays.binarySearch(integers, forSearch);
            if (location >= 0) {
                System.out.println("Location of " + forSearch + " is "
                        + location + ", integers[" + location + "] = " + integers[location]);
                found = integers[location];
                break;
            }
        }
        return found;
    }


    public static void main(String[] args) {

        Task22 task22 = new Task22();
        Integer[] integers = Generated.array(Integer.class, generator, 30);
        System.out.println(Arrays.toString(integers));
        int found = task22.findInt(integers);
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        task22.findInt(integers, found);

    }
}
