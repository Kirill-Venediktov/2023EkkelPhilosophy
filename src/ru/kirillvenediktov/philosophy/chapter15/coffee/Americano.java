package ru.kirillvenediktov.philosophy.chapter15.coffee;

public class Americano extends Coffee {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Americano> {

        @Override
        public Americano create() {
            return new Americano();
        }
    }
}
