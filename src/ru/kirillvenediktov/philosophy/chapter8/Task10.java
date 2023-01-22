package ru.kirillvenediktov.philosophy.chapter8;

public class Task10 {

    public void method1() {
        System.out.println("Method 1");
        method2();
    }

    public void method2() {
        System.out.println("Method 2");
    }
}

class Task10Satelite extends Task10 {

    @Override
    public void method2() {
        System.out.println("Overrided method 2");
    }

    public static void main(String[] args) {
        Task10 task = new Task10Satelite();
        task.method1();
    }
}
