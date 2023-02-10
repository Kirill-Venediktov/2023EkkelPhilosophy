package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter15.coffee.Breve;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Cappuccino;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyCappuccino) {
        probablyCappuccino.add(new Breve());
    }

    public static void main(String[] args) {
        List<Cappuccino> cappuccinos1 = new ArrayList<>();
        oldStyleMethod(cappuccinos1);
        List<Cappuccino> cappuccinos2 = Collections.checkedList(new ArrayList<>(), Cappuccino.class);

        try {
            oldStyleMethod(cappuccinos2);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Coffee> coffees = Collections.checkedList(new ArrayList<>(), Coffee.class);
        coffees.add(new Breve());
        coffees.add(new Cappuccino());
    }
}
