package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        for (Map.Entry<String, String> entry : Countries.capitals().entrySet()) {
            if (entry.getKey().matches("A.+")) {
                capitals.put(entry.getKey(), entry.getValue());
            }
        }
        Set<String> countries = capitals.keySet();
        System.out.println(capitals);
        System.out.println(countries);


    }
}
