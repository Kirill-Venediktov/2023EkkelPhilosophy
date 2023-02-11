package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Mutt extends Dog {

    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
    }

    @Override
    public void speak() {
        System.out.println("Mutt speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Mutt> {

        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
