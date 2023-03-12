package ru.kirillvenediktov.philosophy.chapter18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class ShapeTask30 implements Serializable {

    public static final int RED = 1, BLUE = 2, GREEN = 3;

    private int xPos, yPos, dimension;

    private static Random random = new Random(47);

    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public ShapeTask30(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static ShapeTask30 randomFactory() {
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dim = random.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new CircleTask30(xVal, yVal, dim);
            case 1:
                return new SquareTask30(xVal, yVal, dim);
            case 2:
                return new LineTask30(xVal, yVal, dim);
        }
    }
}

class CircleTask30 extends ShapeTask30 {

    private static int color = RED;

    public CircleTask30(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public static void serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class SquareTask30 extends ShapeTask30 {

    private static int color;

    public static void serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    public SquareTask30(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class LineTask30 extends ShapeTask30 {

    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    public LineTask30(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

public class StoreCADStateTask30 {

    public static void main(String[] args) throws Exception {
        List<ShapeTask30> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            shapes.add(ShapeTask30.randomFactory());
        for (int i = 0; i < 10; i++)
            (shapes.get(i)).setColor(Shape.GREEN);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("CADState.out")
        );
        CircleTask30.serializeStaticState(out);
        SquareTask30.serializeStaticState(out);
        LineTask30.serializeStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
    }
}
