package ru.kirillvenediktov.philosophy.chapter15.coffee;

import ru.kirillvenediktov.philosophy.chapter14.factory.Factory;
import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    static List<Factory<? extends Coffee>> coffeeFactories = new ArrayList<>();

    static {
        coffeeFactories.add(new Americano.Factory());
        coffeeFactories.add(new Breve.Factory());
        coffeeFactories.add(new Cappuccino.Factory());
        coffeeFactories.add(new Latte.Factory());
        coffeeFactories.add(new Mocha.Factory());
    }

    private static Random random = new Random();

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        int n = random.nextInt(coffeeFactories.size());
        return coffeeFactories.get(n).create();
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
