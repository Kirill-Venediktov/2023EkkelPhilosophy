package ru.kirillvenediktov.philosophy.chapter8;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph() перед вызовом draw()");
        draw();
        System.out.println("Glyph() после вызова draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {
    private int a = 1;
    private int b = 2;
    private int c = 3;

    public RectangularGlyph(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println("RectangularGlyph.RectangularGlyph(), a = " + a + ", b = " + b + ", c = " + c);
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), a = " + a + ", b = " + b + ", c = " + c);
    }
}

public class PolyConstructors {

    public static void main(String[] args) {
        new RectangularGlyph(4, 8 , 7);
    }
}
