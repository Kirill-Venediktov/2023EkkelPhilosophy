package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Pug extends Dog {

    public Pug(String name) {
        super(name);
    }

    public Pug() {
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Pug> {

        @Override
        public Pug create() {
            return new Pug();
        }
    }
}
