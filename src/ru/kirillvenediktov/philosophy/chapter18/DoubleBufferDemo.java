package ru.kirillvenediktov.philosophy.chapter18;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class DoubleBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{11.54, 42.87, 47.55, 99.76, 143.32, 811.44, 1016.09});
        System.out.println(db.get(3));
        db.put(3, 1811.00);
        db.flip();
        while (db.hasRemaining()) {
            double i = db.get();
            System.out.println(i);
        }
    }
}
