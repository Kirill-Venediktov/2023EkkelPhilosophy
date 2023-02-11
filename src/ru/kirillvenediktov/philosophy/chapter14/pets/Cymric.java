package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Cymric extends Manx {

    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
    }

    @Override
    public void speak() {
        System.out.println("cymric speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}
