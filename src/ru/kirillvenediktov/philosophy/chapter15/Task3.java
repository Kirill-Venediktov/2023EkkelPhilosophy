package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Cymric;
import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Breve;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Coffee;
import ru.kirillvenediktov.philosophy.util.tuples.SixTuple;

public class Task3 {

    public static void main(String[] args) {
        SixTuple<Integer, String, Double, Coffee, Pet, Boolean> sixTuple = new SixTuple<>(
                42, "String", 3.47, new Breve(), new Cymric(), true
        );
        System.out.println(sixTuple.first);
        System.out.println(sixTuple.second);
        System.out.println(sixTuple.third);
        System.out.println(sixTuple.fourth);
        System.out.println(sixTuple.fifth);
        System.out.println(sixTuple.sixth);
    }
}
