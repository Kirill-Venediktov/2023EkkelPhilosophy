package ru.kirillvenediktov.philosophy.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    public Task3() {
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

}

class Task3Satelite {

    public static final int ITERATIONS_COUNT = 5;

    public static void runExecutorsPool(ExecutorService exec, int iter) {
        for (int i = 0; i < iter; i++) {
            exec.execute(new Task3());
        }
    }

    public static void main(String[] args) {
        ExecutorService exec;
        System.out.println("cashed thread pool");
        exec = Executors.newCachedThreadPool();
        runExecutorsPool(exec, ITERATIONS_COUNT);
        System.out.println("fixed thread pool");
        exec = Executors.newFixedThreadPool(ITERATIONS_COUNT);
        runExecutorsPool(exec, ITERATIONS_COUNT);
        System.out.println("single thread executor");
        exec = Executors.newSingleThreadExecutor();
        runExecutorsPool(exec, ITERATIONS_COUNT);
    }
}
