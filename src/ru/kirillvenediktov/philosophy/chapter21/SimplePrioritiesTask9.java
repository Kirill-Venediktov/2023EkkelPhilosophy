package ru.kirillvenediktov.philosophy.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SimplePrioritiesTask9 implements Runnable {

    private int countDown = 5;

    private volatile double d;

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        UserThreadFactory lowPriorityFactory = new UserThreadFactory(false);
        UserThreadFactory highPriorityFactory = new UserThreadFactory(true);
        for (int i = 0; i < 5; i++) {
            exec.execute(lowPriorityFactory.newThread(new SimplePrioritiesTask9()));
        }
        exec.execute(highPriorityFactory.newThread(new SimplePrioritiesTask9()));
        exec.shutdown();
    }
}

class UserThreadFactory implements ThreadFactory {

    private final boolean isHighPriority;

    public UserThreadFactory(boolean isHighPriority) {
        this.isHighPriority = isHighPriority;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        if (isHighPriority) {
            thread.setPriority(Thread.MAX_PRIORITY);
        } else {
            thread.setPriority(Thread.MIN_PRIORITY);
        }
        return thread;
    }
}
