package ru.kirillvenediktov.philosophy.chapter11;

import java.util.PriorityQueue;

public class Task29 {
}

class Task29Satelite {

    public static void main(String[] args) {
        PriorityQueue<Task29> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(new Task29());
        }

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
