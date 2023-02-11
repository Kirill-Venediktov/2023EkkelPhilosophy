package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Rodent extends Pet {

    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
    }

    @Override
    public void speak() {
        System.out.println("Rodent speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Rodent> {

        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
}
