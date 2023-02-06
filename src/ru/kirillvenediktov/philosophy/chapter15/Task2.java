package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter14.pets.Cat;
import ru.kirillvenediktov.philosophy.chapter14.pets.Cymric;
import ru.kirillvenediktov.philosophy.chapter14.pets.Pet;
import ru.kirillvenediktov.philosophy.chapter14.pets.Rat;

public class Task2<T> {

    private T first;

    private T second;

    private T third;


    public Task2(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    public static void main(String[] args) {
        Task2<Pet> petTask2 = new Task2<>(new Cat(), new Cymric(), new Rat());
        System.out.println(petTask2.getFirst());
        System.out.println(petTask2.getSecond());
        System.out.println(petTask2.getThird());
    }
}
