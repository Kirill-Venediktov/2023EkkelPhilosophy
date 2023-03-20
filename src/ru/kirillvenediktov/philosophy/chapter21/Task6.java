package ru.kirillvenediktov.philosophy.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task6 implements Runnable {

    private static int taskCount = 0;

    private final int id = taskCount++;

    private static Random random = new Random();

    @Override
    public String toString() {
        return "#" + id;
    }

    @Override
    public void run() {
        System.out.println(this + " start");
        int timeout = random.ints(1, 10).findFirst().getAsInt();
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + ": Timeout: " + timeout);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(0);
        } else {
            int iter = Integer.parseInt(args[0]);
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < iter; i++) {
                exec.execute(new Task6());
            }
            exec.shutdown();
        }
    }
}
