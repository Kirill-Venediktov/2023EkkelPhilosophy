package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Rat extends Rodent {

    public Rat(String name) {
        super(name);
    }

    public Rat() {
    }

    @Override
    public void speak() {
        System.out.println("Rat speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
