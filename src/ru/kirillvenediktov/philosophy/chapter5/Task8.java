package ru.kirillvenediktov.philosophy.chapter5;

public class Task8 {

    public void method1() {
        System.out.println("first method");
        method2();
        this.method2();
    }

    public void method2() {
        System.out.println("second method");
    }

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        task8.method1();
    }
}
