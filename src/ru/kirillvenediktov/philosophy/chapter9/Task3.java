package ru.kirillvenediktov.philosophy.chapter9;

public abstract class Task3 {

    public Task3() {
        print();
    }

    public abstract void print();
}

class Task3Satelite extends Task3 {

    private int anInt = 4;

    @Override
    public void print() {
        System.out.println(anInt);
    }

    public static void main(String[] args) {
        Task3Satelite satelite = new Task3Satelite();
        satelite.print();
    }
}
