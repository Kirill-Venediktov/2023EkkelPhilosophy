package ru.kirillvenediktov.philosophy.chapter9;

public abstract class Task4 {

    public abstract void method1();

}

class Task4Satelite extends Task4 {

    public void method1() {
        System.out.println("Method1()");
    }

    public static  void staticMethod(Task4 task4) {
        ((Task4Satelite) task4).method1();
        System.out.println("Метод отработал");
    }

    public static void main(String[] args) {
        staticMethod((new Task4Satelite()));
    }

}
