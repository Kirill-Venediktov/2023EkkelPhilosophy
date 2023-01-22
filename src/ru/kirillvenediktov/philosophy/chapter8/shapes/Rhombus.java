package ru.kirillvenediktov.philosophy.chapter8.shapes;

public class Rhombus extends Shape {

    @Override
    public void draw() {
        System.out.println("Rhombus drawn");
    }

    @Override
    public void erase() {
        System.out.println("Rhombus erased");
    }

    @Override
    public void rotate() {
        System.out.println("Rhombus rotated");
    }
}
