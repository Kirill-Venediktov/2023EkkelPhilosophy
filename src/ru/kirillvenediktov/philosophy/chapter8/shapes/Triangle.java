package ru.kirillvenediktov.philosophy.chapter8.shapes;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle drawn");
    }

    @Override
    public void erase() {
        System.out.println("Triangle erased");
    }

    @Override
    public void rotate() {
        System.out.println("Triangle rotated");
    }
}
