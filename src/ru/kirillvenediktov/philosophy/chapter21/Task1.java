package ru.kirillvenediktov.philosophy.chapter21;

public class Task1 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    public Task1() {
        System.out.println(this + ": Constructor");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this + ": Message!");
            Thread.yield();
        }
        System.out.println(this + ": bye bye");
    }

    @Override
    public String toString() {
        return "#" + id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task1()).start();
        }
    }
}
