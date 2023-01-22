package ru.kirillvenediktov.philosophy.chapter5;

public class Task9 {
    String testString;
    int testInt;

    public Task9(int testInt) {
        this.testInt = testInt;
        System.out.println("constructor with 1 parameter");
    }

    public Task9(String testString, int testInt) {
        this(testInt);
        this.testString = testString;
        System.out.println("constructor with 2 parameters");
    }

    public static void main(String[] args) {
        Task9 task9 = new Task9("hello", 21);
    }
}
