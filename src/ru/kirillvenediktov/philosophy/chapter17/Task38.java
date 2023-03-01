package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task38 {

    private static final int INTEGER_KEY = 3;

    public long testMapPerformance(HashMap<Integer, String> hashMap) {

        long start = System.nanoTime();
        String string = hashMap.get(INTEGER_KEY);
        long finish = System.nanoTime();
        return finish - start;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> firstHashMap = new HashMap<>(30, 0.75f);
        RandomGenerator.String gen = new RandomGenerator.String();
        Task38 task38 = new Task38();
        for (int i = 0; i < 21; i++) {
            firstHashMap.put(i,gen.next());
        }
        HashMap<Integer, String> secondHashMap = new HashMap<>(60, 0.75f);
        for (Map.Entry<Integer, String> entry : firstHashMap.entrySet()) {
            secondHashMap.put(entry.getKey(), entry.getValue());
        }
        long firstTestTime = task38.testMapPerformance(firstHashMap);
        long secondTestTime = task38.testMapPerformance(secondHashMap);
        System.out.println("Searching time of first map: " + firstTestTime);
        System.out.println("Searching time of second map: " + secondTestTime);

    }
}
