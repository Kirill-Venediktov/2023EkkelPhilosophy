package ru.kirillvenediktov.philosophy.chapter15;

public class GenericMethods {

    public <T, K> void f(T x, K y, Integer z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1.0, 1);
        gm.f(1.0F, 'c', 55);
    }
}
