package ru.kirillvenediktov.philosophy.chapter21;

import ru.kirillvenediktov.philosophy.chapter15.Fibonacci;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task4 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    private final int iterationsCount;

    private final Fibonacci gen = new Fibonacci();

    public Task4(int iterationsCount) {
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

}

class Task4Satellite {

    public static final int ITERATIONS_COUNT = 5;

    public static void runExecutorsPool(ExecutorService exec, int iter) {
        Random random = new Random();
        for (int i = 0; i < iter; i++) {
            int count = random.nextInt(7);
            exec.execute(new Task4(count));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
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
