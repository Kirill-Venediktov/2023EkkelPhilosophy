package ru.kirillvenediktov.philosophy.chapter8.shapes;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }

    @Override
    public void erase() {
        System.out.println("Circle erased");
    }

    @Override
    public void rotate() {
        System.out.println("Circle rotated");
    }
}
