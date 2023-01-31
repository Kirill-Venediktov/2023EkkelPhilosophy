package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.Task25Exception;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.Task25ExceptionGrandson;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.Task25ExceptionSon;

public class A {
    public void method() throws Task25Exception {
        throw new Task25Exception();
    }
}

class B extends A {

    @Override
    public void method() throws Task25ExceptionSon {
        throw new Task25ExceptionSon();
    }
}

class C extends B {

    @Override
    public void method() throws Task25ExceptionGrandson {
        throw new Task25ExceptionGrandson();
    }

    public static void main(String[] args) {
        A a = new C();

        try {
            a.method();
        } catch (Task25Exception e) {
            e.printStackTrace();
        }
    }
}