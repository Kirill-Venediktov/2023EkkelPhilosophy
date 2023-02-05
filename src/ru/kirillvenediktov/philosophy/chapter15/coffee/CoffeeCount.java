package ru.kirillvenediktov.philosophy.chapter15.coffee;

import ru.kirillvenediktov.philosophy.util.TypeCounter;

public class CoffeeCount {

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Coffee.class);
        for (Coffee coffee : new CoffeeGenerator(20)) {
            typeCounter.count(coffee);
        }
        System.out.println();
        System.out.println(typeCounter);
    }

}
