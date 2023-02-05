package ru.kirillvenediktov.philosophy.chapter14.pets;

import java.util.List;

public class Pets {

//    public static final PetCreator creator = new LiteralPetCreator();
    public static final PetCreator creator = new PetCreator15();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static List<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
