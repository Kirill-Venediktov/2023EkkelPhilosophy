package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task42 implements Comparable<Task42> {

    private String stringOne;
    private String stringTwo;

    public Task42(String stringOne, String stringTwo) {
        this.stringOne = stringOne;
        this.stringTwo = stringTwo;
    }

    public String getStringOne() {
        return stringOne;
    }

    public void setStringOne(String stringOne) {
        this.stringOne = stringOne;
    }

    public String getStringTwo() {
        return stringTwo;
    }

    public void setStringTwo(String stringTwo) {
        this.stringTwo = stringTwo;
    }

    @Override
    public String toString() {
        return "Task40{" +
                "stringOne='" + stringOne + '\'' +
                ", stringTwo='" + stringTwo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task42 task42 = (Task42) o;
        return Objects.equals(stringOne, task42.stringOne) &&
                Objects.equals(stringTwo, task42.stringTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringOne, stringTwo);
    }

    @Override
    public int compareTo(Task42 o) {
        return stringOne.compareToIgnoreCase(o.stringOne);
    }
}

class ComparatorTask42 implements Comparator<Task42> {

    @Override
    public int compare(Task42 o1, Task42 o2) {
        return o1.getStringTwo().compareToIgnoreCase(o2.getStringTwo());
    }
}

class Task42Satelite {

    public static void main(String[] args) {
        RandomGenerator.String gen = new RandomGenerator.String();
        Task40[] array = new Task40[15];
        List<Task40> list = new ArrayList<>();
        String stringOne = null;
        String stringTwo = null;
        for (int i = 0; i < array.length; i++){
            stringOne = gen.next();
            stringTwo = gen.next();
            Task40 task40 = new Task40(stringOne, stringTwo);
            array[i] = task40;
            list.add(task40);
        }
        System.out.println("First word comparing:");
        Arrays.sort(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
        System.out.println(list);

        System.out.println("Second word comparing:");
        Arrays.sort(array, new ComparatorTask40());
        list.sort(new ComparatorTask40());
        System.out.println(Arrays.toString(array));
        System.out.println(list);

        System.out.println("Binary search:");
        int index = Collections.binarySearch(list, new Task40(stringOne, stringTwo), new ComparatorTask40());
        System.out.println("index : " + index + " element: " + list.get(index));
    }
}
