package ru.kirillvenediktov.philosophy.chapter14.pets;

public class Mouse extends Rodent {

    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Mouse> {

        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
}
