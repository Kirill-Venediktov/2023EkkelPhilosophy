package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog() {
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Dog> {

        @Override
        public Dog create() {
            return new Dog();
        }
    }
}
