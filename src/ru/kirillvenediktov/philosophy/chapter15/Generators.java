package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter15.coffee.Coffee;
import ru.kirillvenediktov.philosophy.chapter15.coffee.CoffeeGenerator;
import ru.kirillvenediktov.philosophy.util.Fibonacci;
import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Generators {

//    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
//        for (int i = 0; i < n; i++) {
//            coll.add(gen.next());
//        }
//        return coll;
//    }

    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> Set<T> fill(Set<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
//        Collection<Integer> integers = fill(new LinkedList<>(), new Fibonacci(), 12);
//        for (int i : integers) {
//            System.out.print(i);
//        }
//    }
    }
}
