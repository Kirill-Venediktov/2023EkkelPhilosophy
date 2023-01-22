package ru.kirillvenediktov.philosophy.chapter2;

public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree();
            t.info();
            t.info("перегруженный метод");
        }
        new Tree();
    }
}
