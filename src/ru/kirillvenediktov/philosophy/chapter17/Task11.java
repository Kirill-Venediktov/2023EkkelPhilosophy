package ru.kirillvenediktov.philosophy.chapter17;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;

public class Task11 implements Comparable<Task11> {

    private static final int RANDOM_LIMIT = 100;

    private static final Random RANDOM = new Random();

    private final int anInt = RANDOM.nextInt(RANDOM_LIMIT);

    public int getAnInt() {
        return anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task11 task11 = (Task11) o;
        return anInt == task11.anInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt);
    }

    @Override
    public String toString() {
        return "Task11{" +
                "anInt=" + anInt +
                '}';
    }

    @Override
    public int compareTo(Task11 o) {
        return Integer.compare(anInt, o.anInt);
    }
}

class Task11Satelite {

    public static void main(String[] args) {
        PriorityQueue<Task11> queue = new PriorityQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.offer(new Task11());
        }

        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }

    }
}
