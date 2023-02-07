package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class LittleFish {

    private static long counter = 1;

    private final long id = counter++;

    private LittleFish() {
    }

    @Override
    public String toString() {
        return "LittleFish{" +
                "id=" + id +
                '}';
    }

    public static Generator<LittleFish> generator() {
        return LittleFish::new;
    }
}

class BigFish {

    private static long counter = 1;

    private final long id = counter++;

    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish{" +
                "id=" + id +
                '}';
    }

    public static Generator<BigFish> generator() {
        return BigFish::new;
    }
}


public class Ocean {

    public static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(bigFish + " eats " + littleFish);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Queue<LittleFish> line = new LinkedList<>();
        Generators.fill(line, LittleFish.generator(), 15);
        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 4);
        for (LittleFish littleFish : line) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), littleFish);
        }
    }

}
