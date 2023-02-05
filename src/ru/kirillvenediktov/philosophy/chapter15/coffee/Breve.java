package ru.kirillvenediktov.philosophy.chapter15.coffee;

public class Breve extends Coffee {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Breve> {

        @Override
        public Breve create() {
            return new Breve();
        }
    }
}
