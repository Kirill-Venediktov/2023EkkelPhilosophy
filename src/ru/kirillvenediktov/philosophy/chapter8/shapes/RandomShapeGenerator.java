package ru.kirillvenediktov.philosophy.chapter8.shapes;

import java.util.Random;

public class RandomShapeGenerator {
    private Random random = new Random();

    public Shape next() {
        Shape shape = null;
        switch (random.nextInt(4)) {
            case 0:
                shape = new Circle();
                break;
            case 1:
                shape = new Square();
                break;
            case 2:
                shape = new Triangle();
                break;
            case 3:
                shape = new Rhombus();
        }
        return shape;
    }
}
