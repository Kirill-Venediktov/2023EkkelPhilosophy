package ru.kirillvenediktov.philosophy.chapter7;

class Insect {
    private int i = 9;
    protected int j;
    private static int x1 = printInit("Поле static Insect.x1 инициализированно");

    public Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Поле Beetle.k инициализированно");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("Поле static Beetle.x2 инициализированно");

    public static void main(String[] args) {
        System.out.println("Конструктор Beetle");
        Beetle beetle = new Beetle();
    }
}

class Chafer extends Beetle {
    private int l = printInit("Поле Chafer.l инициализированно");
    private static int x3 = printInit("Поле static Chafer.x3 инициализированно");

    public Chafer() {
        System.out.println("j = " + j);
    }

    public static void main(String[] args) {
        System.out.println("Конструктор Chafer");
        Chafer chafer = new Chafer();
    }
}