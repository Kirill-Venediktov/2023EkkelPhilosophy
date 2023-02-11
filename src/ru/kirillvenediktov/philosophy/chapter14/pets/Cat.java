package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    @Override
    public void speak() {
        System.out.println("meow");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Cat> {

        @Override
        public Cat create() {
            return new Cat();
        }
    }
}
