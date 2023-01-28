package ru.kirillvenediktov.philosophy.chapter8.shapes;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable {

    private Random random = new Random();

    int elementCount;

    public RandomShapeGenerator(int elementCount) {
        this.elementCount = elementCount;
    }

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

    @Override
    public Iterator iterator() {
        return new Iterator() {

            int countOfGenerated = 0;

            @Override
            public boolean hasNext() {
                boolean hasNext = true;
                if (countOfGenerated > elementCount) {
                    hasNext = false;
                }
                return hasNext;
            }

            @Override
            public Object next() {
                countOfGenerated++;
                return RandomShapeGenerator.this.next();
            }
        };
    }

    public static void main(String[] args) {
        RandomShapeGenerator generator = new RandomShapeGenerator(5);
        Iterator iterator = generator.iterator();
        while (iterator.hasNext()) {
            Shape shape = (Shape) iterator.next();
            shape.rotate();
            shape.draw();
            shape.erase();
        }

    }
}
