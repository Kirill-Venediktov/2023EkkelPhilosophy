package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Cat> {

        @Override
        public Cat create() {
            return new Cat();
        }
    }
}
