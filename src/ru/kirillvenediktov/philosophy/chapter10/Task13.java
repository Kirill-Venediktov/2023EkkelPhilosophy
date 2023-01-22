package ru.kirillvenediktov.philosophy.chapter10;

public class Task13 {

    public Task9Interface getTask9Interface() {
        return () -> System.out.println("Method one");
    }

    public static void main(String[] args) {
        Task13 task13 = new Task13();
        task13.getTask9Interface().method();
    }
}
