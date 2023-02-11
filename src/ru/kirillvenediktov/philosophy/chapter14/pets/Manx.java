package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Manx extends Cat {

    public Manx(String name) {
        super(name);
    }

    public Manx() {
    }

    @Override
    public void speak() {
        System.out.println("Manx speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Manx> {

        @Override
        public Manx create() {
            return new Manx();
        }
    }
}
