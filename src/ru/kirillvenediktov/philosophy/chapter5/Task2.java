package ru.kirillvenediktov.philosophy.chapter5;

public class Task2 {
    String testString = "Hello";
    String secondTestString;

    public Task2(String secondTestString) {
        this.secondTestString = secondTestString;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2("good monin'");
        System.out.println(task2.testString);
        System.out.println(task2.secondTestString);
    }
}
