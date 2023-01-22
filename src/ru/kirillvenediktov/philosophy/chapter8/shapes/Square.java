package ru.kirillvenediktov.philosophy.chapter8.shapes;

public class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square drawn");
    }

    @Override
    public void erase() {
        System.out.println("Square erased");
    }

    @Override
    public void rotate() {
        System.out.println("Square rotated");
    }
}
