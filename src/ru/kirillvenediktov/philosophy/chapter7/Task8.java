package ru.kirillvenediktov.philosophy.chapter7;

class Task8Satelite {

    public Task8Satelite(int i) {
        System.out.println("Конструктор Task8Satelite. i = " + i);
    }
}

public class Task8 extends Task8Satelite {

    public Task8(int i) {
        super(i);
        System.out.println("Конструктор Task 8 с аргументами.");
    }

    public Task8() {
        super(16);
        System.out.println("Конструктор Task 8 без аргументов.");
    }

    public static void main(String[] args) {
        Task8 task1 = new Task8();
        Task8 t2 = new Task8(11);
    }
}
