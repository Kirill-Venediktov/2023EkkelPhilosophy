package ru.kirillvenediktov.philosophy.chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Task17 {

    public static void main(String[] args) {

        Map<String, Gerbil> gerbilMap = new HashMap<>();
        Gerbil gerbil;

        for (int i = 0; i < 10; i++) {
            gerbil = new Gerbil(i);
            gerbil.setRandomName();
            gerbilMap.put(gerbil.getName(), gerbil);
        }

        Iterator<String> iterator = gerbilMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Key: " + key);
            gerbilMap.get(key).hop();
        }
    }

}
