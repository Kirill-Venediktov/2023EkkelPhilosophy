package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Pet {

    public Pet(String name) {
    }

    public Pet() {
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Pet> {

        @Override
        public Pet create() {
            return new Pet();
        }
    }
}
