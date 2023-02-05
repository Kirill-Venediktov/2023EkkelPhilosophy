package ru.kirillvenediktov.philosophy.chapter15.coffee;

public class Latte extends Coffee {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Latte> {

        @Override
        public Latte create() {
            return new Latte();
        }
    }
}
