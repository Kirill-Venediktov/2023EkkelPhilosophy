package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Cat;
import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;

public class Holder3<T> {

    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Pet> petHolder = new Holder3<>(new Cat());
        System.out.println(petHolder.getA());
    }
}
