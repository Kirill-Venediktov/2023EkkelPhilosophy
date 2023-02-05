package ru.kirillvenediktov.philosophy.chapter15.coffee;

public class Mocha extends Coffee {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Mocha> {

        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
}
