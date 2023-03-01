package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Task41 implements Comparable<Task41> {

    private String stringOne;

    private String stringTwo;

    public Task41(String stringOne, String stringTwo) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task41 task41 = (Task41) o;
        return Objects.equals(stringOne, task41.stringOne) &&
                Objects.equals(stringTwo, task41.stringTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringOne, stringTwo);
    }

    @Override
    public String toString() {
        return "Task41{" +
                "stringOne='" + stringOne + '\'' +
                ", stringTwo='" + stringTwo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Task41 o) {
        return stringOne.compareTo(o.stringOne);
    }
}

class ComparatorTask41 implements Comparator<Task41> {

    @Override
    public int compare(Task41 o1, Task41 o2) {
        return o1.getStringTwo().compareTo(o2.getStringTwo());
    }
}

class Task41Satelite {

    public static void main(String[] args) {
        RandomGenerator.String gen = new RandomGenerator.String();
        String stringOne = null;
        String stringTwo = null;

        Set<Task41> hashSet = new HashSet<>();
        Map<Task41, String> hashMap = new HashMap<>();

        for (int i = 0; i < 15; i++) {
            stringOne = gen.next();
            stringTwo = gen.next();
            Task41 task41 = new Task41(stringOne, stringTwo);
            hashSet.add(task41);
            hashMap.put(task41, stringTwo);
        }
        System.out.println(hashSet);
        System.out.println(hashMap);
    }
}
