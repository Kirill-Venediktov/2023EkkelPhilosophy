package ru.kirillvenediktov.philosophy.chapter11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task19 {

    public static void main(String[] args) {
        Set<Gerbil> gerbils = new HashSet<>();
        Set<Gerbil> linkedHashSet = new LinkedHashSet<>();
        Gerbil gerbil;
        for (int i = 0; i < 14; i++) {
            gerbil = new Gerbil(i);
            gerbil.setRandomName();
            gerbils.add(gerbil);
        }
        System.out.println(gerbils);
        for (Gerbil g : gerbils) {
            linkedHashSet.add(g);
        }
        System.out.println(linkedHashSet);
    }

}
