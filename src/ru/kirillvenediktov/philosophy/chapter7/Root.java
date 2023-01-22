package ru.kirillvenediktov.philosophy.chapter7;

class Component1 {

    public Component1(int i) {
        System.out.println("Component1");
    }

    public void dispose() {
        System.out.println("Стираем Component1");
    }
}

class Component2 {

    public Component2(int i) {
        System.out.println("Component2");
    }

    public void dispose() {
        System.out.println("Стираем Component2");
    }
}

class Component3 {

    public Component3(int i) {
        System.out.println("Component3");
    }

    public void dispose() {
        System.out.println("Стираем Component3");
    }
}

public class Root {

    public Root(int i) {
        System.out.println("Root");
    }

    private Component1 component1 = new Component1(12);
    private Component2 component2 = new Component2(12);
    private Component3 component3 = new Component3(14);

    public void dispose() {
        System.out.println("Стираем Root");
    }
}

class Stem extends Root {

    private Component1 component1 = new Component1(15);
    private Component2 component2 = new Component2(11);
    private Component3 component3 = new Component3(17);

    public Stem(int i) {
        super(i);
        System.out.println("Stem");
    }

    public void dispose() {
        System.out.println("Стираем Stem");
        super.dispose();
    }

    public static void main(String[] args) {
        Stem stem = new Stem(11);
        stem.dispose();
    }

}
