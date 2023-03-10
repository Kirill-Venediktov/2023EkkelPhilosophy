package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Gerbil extends Rodent {

    public Gerbil(String name) {
        super(name);
    }

    public Gerbil() {
    }

    @Override
    public void speak() {
        System.out.println("Gerbil speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Gerbil> {

        @Override
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
