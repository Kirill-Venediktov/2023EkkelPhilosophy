package ru.kirillvenediktov.philosophy.chapter21;

import ru.kirillvenediktov.philosophy.chapter15.Fibonacci;

import java.util.Random;

public class Task2 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    private final int iterationsCount;

    private final Fibonacci gen = new Fibonacci();

    public Task2(int iterationsCount) {
        this.iterationsCount = iterationsCount;
    }

    @Override
    public String toString() {
        return "#" + id;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterationsCount; i++) {
            System.out.println(this + " " + gen.next());
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(new Task2(random.nextInt(7))).start();
        }
    }
}
