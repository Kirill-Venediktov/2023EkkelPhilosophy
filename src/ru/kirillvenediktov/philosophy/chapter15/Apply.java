package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;
import ru.kirillvenediktov.philosophy.chapter14.pets.PetCreator15;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {

    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                f.invoke(t, args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++) {
                add(type.getConstructor().newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest {

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        PetCreator15 creator = new PetCreator15();
        for (int i = 0; i < 10; i++) {
            pets.add(creator.randomPet());
        }
        try {
            Apply.apply(pets, Pet.class.getMethod("speak"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
