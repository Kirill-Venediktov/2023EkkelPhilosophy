package ru.kirillvenediktov.philosophy.chapter15;

interface Task20Interface {

    void methodOne();

    void methodTwo();
}

public class Task20 implements Task20Interface {

    @Override
    public void methodOne() {
        System.out.println("Method 1");
    }

    @Override
    public void methodTwo() {
        System.out.println("Method 2");
    }

    public void methodThree() {
        System.out.println("Method 3");
    }
}


class Task20Satelite {

    public <T extends Task20Interface> void genericMethod(T x) {
        x.methodOne();
        x.methodTwo();
    }

    public static void main(String[] args) {
        Task20 task20 = new Task20();
        Task20Satelite satelite = new Task20Satelite();
        satelite.genericMethod(task20);
    }
}