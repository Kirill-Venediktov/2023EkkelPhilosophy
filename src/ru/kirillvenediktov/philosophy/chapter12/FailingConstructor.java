package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class FailingConstructor {

    Inner inner;

    public FailingConstructor() {
        this.inner = new Inner();
        try {
            throw new MyException("Exception text");
        } catch (MyException e) {
            e.printStackTrace();
        }
        new Inner().dispose();
    }

    class Inner {

        void dispose() {
            System.out.println("Inner.dispose()");
        }
    }

    public void dispose() {
        System.out.println("failingConstructor.dispose()");
    }

    public static void main(String[] args) {
        FailingConstructor failingConstructor = new FailingConstructor();
        failingConstructor.dispose();
    }
}
