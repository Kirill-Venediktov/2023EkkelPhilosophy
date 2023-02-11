package ru.kirillvenediktov.philosophy.chapter14.pets;

public class EgyptianMau extends Cat {

    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
    }

    @Override
    public void speak() {
        System.out.println("Egyptian mau speaks");
    }

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<EgyptianMau> {

        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
