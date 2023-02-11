package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog() {
    }

    @Override
    public void speak() {
        System.out.println("bark bark");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Dog> {

        @Override
        public Dog create() {
            return new Dog();
        }
    }
}
