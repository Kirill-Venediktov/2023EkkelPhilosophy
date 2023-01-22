package ru.kirillvenediktov.philosophy.chapter9;

interface Task14SateliteOne {

    void method1();

    void method2();
}

interface Task14SateliteTwo {

    void method3();

    void method4();

}

interface Task14SateliteThree {

    void method5();

    void method6();

}

public interface Task14 extends Task14SateliteOne, Task14SateliteTwo, Task14SateliteThree {

    void method7();
}

abstract class Task14Father {

}

class Task14Class extends Task14Father implements Task14 {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }

    @Override
    public void method5() {

    }

    @Override
    public void method6() {

    }

    @Override
    public void method7() {

    }

    public static void methodWithArgumentOne(Task14SateliteOne sateliteOne) {
        System.out.println("methodWithArgumentOne()");
    }

    public static void methodWithArgumentTwo(Task14SateliteTwo sateliteTwo) {
        System.out.println("methodWithArgumentTwo()");
    }

    public static void methodWithArgumentThree(Task14SateliteThree sateliteThree) {
        System.out.println("methodWithArgumentThree()");
    }

    public static void methodWithArgumentFour(Task14 task14) {
        System.out.println("methodWithArgumentFour()");
    }

    public static void main(String[] args) {
        Task14Class task14Class = new Task14Class();
        methodWithArgumentOne(task14Class);
        methodWithArgumentTwo(task14Class);
        methodWithArgumentThree(task14Class);
        methodWithArgumentFour(task14Class);
    }
}
