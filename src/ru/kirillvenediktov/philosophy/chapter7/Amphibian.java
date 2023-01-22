package ru.kirillvenediktov.philosophy.chapter7;

public class Amphibian {

    public void swim() {

    }

    public void walk() {

    }

    public void scream() {

    }

}

class Frog extends Amphibian {

    @Override
    public void swim() {
        System.out.println("Frog swim");
    }

    @Override
    public void walk() {
        System.out.println("Frog walk");
    }

    @Override
    public void scream() {
        System.out.println("Qaaaaa");
    }

    public static void main(String[] args) {
        Amphibian frog = new Frog();
        frog.scream();
        frog.swim();
        frog.walk();
    }
}
