package ru.kirillvenediktov.philosophy.chapter14.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "ru.kirillvenediktov.philosophy.chapter14.pets.Mutt",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Pug",
            "ru.kirillvenediktov.philosophy.chapter14.pets.EgyptianMau",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Manx",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Cymric",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Rat",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Mouse",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Hamster",
            "ru.kirillvenediktov.philosophy.chapter14.pets.Gerbil"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
