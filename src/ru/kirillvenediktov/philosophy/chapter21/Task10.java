package ru.kirillvenediktov.philosophy.chapter21;

import ru.kirillvenediktov.philosophy.chapter15.Fibonacci;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task10 {

    private static int taskCount = 0;

    private final int id = taskCount++;

    private final Fibonacci gen = new Fibonacci();

    private final ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public String toString() {
        return "#" + id;
    }

    public ExecutorService getExec() {
        return exec;
    }

    public Future<Integer> runTask(int iterationsCount) {
        gen.setCount(0);
        Callable<Integer> callable = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < iterationsCount; i++) {
                    sum += gen.next();
                }
                return sum;
            }
        };
        return exec.submit(callable);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Task10 task10 = new Task10();
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            try {
                sum += task10.runTask(random.nextInt(7)).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }

}
