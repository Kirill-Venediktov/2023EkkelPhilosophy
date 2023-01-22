package ru.kirillvenediktov.philosophy.chapter10;

public class Task12 {

    private String stringField = "Hello";

    private void methodOne() {
        System.out.println("Method one");
    }

    public void methodTwo() {
        ((Task9Interface) () -> {
            stringField = "Changed by inner class";
            methodOne();
        }).method();
    }

    public static void main(String[] args) {
        Task12 task12 = new Task12();
        task12.methodTwo();
        System.out.println(task12.stringField);
    }
}
