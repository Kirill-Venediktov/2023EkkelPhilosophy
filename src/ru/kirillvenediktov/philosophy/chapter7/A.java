package ru.kirillvenediktov.philosophy.chapter7;

public class A {

    public A(int i) {
        System.out.println("Конструктор A");
    }
}

class B {

    public B(int i) {
        System.out.println("Конструктор B");
    }
}

class C extends A {

    B b;

    public C(int i) {
        super(i);
    }

    public static void main(String[] args) {
        C c = new C(11);
    }
}


