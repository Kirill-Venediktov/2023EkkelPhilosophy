package ru.kirillvenediktov.philosophy.chapter11;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Task24 {

    public static void main(String[] args) {
        OfficeCharacter[] names = OfficeCharacter.values();
        Random random = new Random();
        Map<String, String> lhm = new LinkedHashMap<>();
        for (int i = 0; i < 15; i++) {
            lhm.put(names[random.nextInt(names.length)].toString(), names[random.nextInt(names.length)].toString());
        }
        System.out.println(lhm);
        TreeMap<String, String> treeMap = new TreeMap<>(lhm);
        lhm.clear();
        lhm.putAll(treeMap);
        System.out.println(lhm);
    }
}
