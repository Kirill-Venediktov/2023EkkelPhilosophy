package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;
import ru.kirillvenediktov.philosophy.chapter14.pets.PetCreator15;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Coffee;
import ru.kirillvenediktov.philosophy.chapter15.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();

    private Random random = new Random();

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }

        RandomList<Coffee> coffeeRandomList = new RandomList<>();
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();

        for (int i = 0; i < 7; i++) {
            coffeeRandomList.add(coffeeGenerator.next());
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            System.out.print(coffeeRandomList.select() + " ");
        }

        RandomList<Pet> petRandomList = new RandomList<>();
        PetCreator15 petCreator15 = new PetCreator15();
        for (int i = 0; i < 8; i++) {
            petRandomList.add(petCreator15.randomPet());
        }
        System.out.println();

        for (int i = 0; i < 11; i++) {
            System.out.print(petRandomList.select() + " ");
        }
    }
}
