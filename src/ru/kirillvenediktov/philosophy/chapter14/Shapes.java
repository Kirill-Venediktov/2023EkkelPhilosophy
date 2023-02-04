package ru.kirillvenediktov.philosophy.chapter14;

import java.util.Arrays;
import java.util.List;

abstract class Shape {

    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {

    private static boolean Allocated;

    public static boolean isAllocated() {
        return Allocated;
    }

    public static void setAllocated(boolean allocated) {
        Allocated = allocated;
    }

    @Override
    public String toString() {
        return "Circle. Allocated = " + isAllocated();
    }
}

class Square extends Shape {

    private static boolean Allocated;

    public static boolean isAllocated() {
        return Allocated;
    }

    public static void setAllocated(boolean allocated) {
        Allocated = allocated;
    }

    @Override
    public String toString() {
        return "Square. Allocated = " + isAllocated();
    }
}

class Triangle extends Shape {

    private static boolean Allocated;

    public static boolean isAllocated() {
        return Allocated;
    }

    public static void setAllocated(boolean allocated) {
        Allocated = allocated;
    }

    @Override
    public String toString() {
        return "Triangle. Allocated = " + isAllocated();
    }
}

class Rhomboid extends Shape {

    private static boolean Allocated;

    public static boolean isAllocated() {
        return Allocated;
    }

    public static void setAllocated(boolean allocated) {
        Allocated = allocated;
    }

    @Override
    public String toString() {
        return "Rhomboid. Allocated =" + isAllocated();
    }
}

public class Shapes {

    public static void rotate(Shape shape) {
        if (!(shape instanceof Circle)) {
            System.out.println(shape + " is rotated");
        }
    }

    public static void select(Shape shape) {
        if (shape instanceof Circle) {
            Circle.setAllocated(true);
        } else if (shape instanceof Square) {
            Square.setAllocated(true);
        } else if (shape instanceof Triangle) {
            Triangle.setAllocated(true);
        } else if (shape instanceof Rhomboid) {
            Rhomboid.setAllocated(true);
        }
    }

    public static void cancelSelection(Shape shape) {
        if (shape instanceof Circle) {
            Circle.setAllocated(false);
        } else if (shape instanceof Square) {
            Square.setAllocated(false);
        } else if (shape instanceof Triangle) {
            Triangle.setAllocated(false);
        } else if (shape instanceof Rhomboid) {
            Rhomboid.setAllocated(false);
        }
    }

    public static void showClassHierarchy(Object o) {

        Class c = o.getClass();
        System.out.println(c);
        System.out.println(Arrays.toString(c.getDeclaredFields()));
        while (c.getSuperclass() != null) {
            c = c.getSuperclass();
            System.out.println(Arrays.toString(c.getDeclaredFields()));
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        for (Shape shape : shapeList) {
            shape.draw();
            rotate(shape);
        }
        select(shapeList.get(2));
        for (Shape shape : shapeList) {
            System.out.println(shape);
        }


        Shape rhomboid = new Rhomboid();
        rhomboid.draw();
        if (rhomboid instanceof Rhomboid) {
            ((Rhomboid) rhomboid).draw();
        }
        if (rhomboid instanceof Circle) {
            ((Circle) rhomboid).draw();
        } else {
            System.out.println("не Circle");
        }

        showClassHierarchy(rhomboid);

    }

}
