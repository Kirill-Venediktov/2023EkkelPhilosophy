package ru.kirillvenediktov.philosophy.chapter2;

class IntegerCarrier {
    static int anInt = 15;
}

public class Task8 {

    public static void main(String[] args) {
        IntegerCarrier carrier1 = new IntegerCarrier();
        IntegerCarrier carrier2 = new IntegerCarrier();
        System.out.println(carrier1.anInt);
        System.out.println(carrier2.anInt);
        IntegerCarrier.anInt++;
        System.out.println(carrier1.anInt);
        System.out.println(carrier2.anInt);
    }
}
