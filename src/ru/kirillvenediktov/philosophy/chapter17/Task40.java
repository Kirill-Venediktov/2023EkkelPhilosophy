package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task40 implements Comparable<Task40> {

    private String stringOne;
    private String stringTwo;

    public Task40(String stringOne, String stringTwo) {
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
        Task40 task40 = (Task40) o;
        return Objects.equals(stringOne, task40.stringOne) &&
                Objects.equals(stringTwo, task40.stringTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringOne, stringTwo);
    }


    @Override
    public int compareTo(Task40 o) {
        return stringOne.compareTo(o.stringOne);
    }
}

class ComparatorTask40 implements Comparator<Task40> {

    @Override
    public int compare(Task40 o1, Task40 o2) {
        return o1.getStringTwo().compareTo(o2.getStringTwo());
    }
}

class Task40Satelite {

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
