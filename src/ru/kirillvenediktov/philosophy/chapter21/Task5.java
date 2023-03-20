package ru.kirillvenediktov.philosophy.chapter21;

import ru.kirillvenediktov.philosophy.chapter15.Fibonacci;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task5 implements Callable<Integer> {

    private static int taskCount = 0;

    private final int id = taskCount++;

    private final int iterationsCount;

    private final Fibonacci gen = new Fibonacci();

    public Task5(int iterationsCount) {
        this.iterationsCount = iterationsCount;
    }

    @Override
    public String toString() {
        return "#" + id;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < iterationsCount; i++) {
            sum += gen.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            try {
                sum += exec.submit(new Task5(random.nextInt(7))).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
        exec.shutdown();
    }

}
