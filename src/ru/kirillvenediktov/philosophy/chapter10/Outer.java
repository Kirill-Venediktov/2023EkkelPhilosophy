package ru.kirillvenediktov.philosophy.chapter10;

public class Outer {

    private String string;

    public Outer(String string) {
        this.string = string;
    }

    class Inner {

        public Inner() {
            System.out.println("Inner()");
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("Test String");
        Inner inner = outer.getInner();
    }
}

class Task1 {

    public static void main(String[] args) {
        Outer outer = new Outer("Test string");
        Outer.Inner inner = outer.getInner();
        System.out.println(inner.toString());
    }
}
