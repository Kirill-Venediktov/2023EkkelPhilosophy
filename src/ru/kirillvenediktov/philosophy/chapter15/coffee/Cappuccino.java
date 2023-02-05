package ru.kirillvenediktov.philosophy.chapter15.coffee;

public class Cappuccino extends Coffee {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Cappuccino> {

        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    }
}
