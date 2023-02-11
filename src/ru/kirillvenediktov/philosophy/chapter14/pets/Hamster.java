package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Hamster extends Rodent {

    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
    }

    @Override
    public void speak() {
        System.out.println("Hamster speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Hamster> {

        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}
