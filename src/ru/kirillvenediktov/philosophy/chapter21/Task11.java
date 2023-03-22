package ru.kirillvenediktov.philosophy.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task11 {

    private volatile boolean canceled = false;

    private double aDouble = 0;

    private int anInt = 0;

    public synchronized double getaDouble() {
        return aDouble;
    }

    public synchronized int getAnInt() {
        return anInt;
    }

    public synchronized boolean isCanceled() {
        return canceled;
    }

    public void cancel() {
        canceled = true;
    }


    public synchronized void add() {
        aDouble += 0.25;
        Thread.yield();
        ++anInt;
        aDouble += 0.25;
        Thread.yield();
        ++anInt;
        aDouble += 0.25;
        aDouble += 0.25;
    }
}

class Task11Runner implements Runnable {

    private Task11 task11;

    private int id;

    public Task11Runner(Task11 task11, int id) {
        this.task11 = task11;
        this.id = id;
    }

    @Override
    public void run() {
        while (!task11.isCanceled()) {
            task11.add();
            int i = task11.getAnInt();
            double d = task11.getaDouble();
            if (i % 2 != 0 || d % 1 != 0) {
                System.out.println("i = " + i + ", d = " + d);
                task11.cancel();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        Task11 task11 = new Task11();

        for (int i = 0; i < 7; i++) {
            exec.execute(new Task11Runner(task11, i));
        }
        exec.shutdown();
    }
}
