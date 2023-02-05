package ru.kirillvenediktov.philosophy.chapter14.pets;

import ru.kirillvenediktov.philosophy.chapter14.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetCreator15 extends PetCreator {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();

    static {
        petFactories.add(new Cat.Factory());
        petFactories.add(new Cymric.Factory());
        petFactories.add(new Dog.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Gerbil.Factory());
        petFactories.add(new Hamster.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Pet.Factory());
        petFactories.add(new Rodent.Factory());
    }

    private static Random random = new Random(47);

    @Override
    public Pet randomPet() {
        int n = random.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        List<Class<? extends Pet>> types = new ArrayList<>();
        for (Factory<? extends Pet> factory : petFactories) {
            types.add(factory.create().getClass());
        }
        return types;
    }
}
