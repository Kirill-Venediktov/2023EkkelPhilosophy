package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;
import ru.kirillvenediktov.philosophy.chapter14.pets.PetCreator15;

public class Generic1<T> {

    public <T> void methodOne(T t) {
        System.out.println("t = " + t);
    }
}

class Generic2<T> {

    public <T> T methodTwo(T t) {

        return t;
    }
}

class Task28 {

    public static  <T extends Pet> void covariantMethod(Generic1<? extends Pet> gen, T t) {
        gen.methodOne(t);
    }

    public static void main(String[] args) {
        PetCreator15 creator15 = new PetCreator15();
        Generic1<Pet> generic1 = new Generic1<>();

        for (int i = 0; i < 5; i++) {
          covariantMethod(generic1, creator15.randomPet());
        }
    }
}
