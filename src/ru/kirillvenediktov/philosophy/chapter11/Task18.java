package ru.kirillvenediktov.philosophy.chapter11;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Task18 {

    public static void main(String[] args) {

        Map<Integer, Gerbil> gerbilMap = new HashMap<>();
        for (int i = 0; i < 14; i++) {
            gerbilMap.put(i, new Gerbil(i));
        }
        System.out.println(gerbilMap);
        Set<Map.Entry<Integer, Gerbil>> entrySet = gerbilMap.entrySet();
        System.out.println(entrySet);
        Map<Integer, Gerbil> linkedHashMapGerbils = new LinkedHashMap<>();
        for (Map.Entry<Integer, Gerbil> entry : entrySet) {
            linkedHashMapGerbils.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMapGerbils);

    }


}
