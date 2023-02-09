package ru.kirillvenediktov.philosophy.chapter15;

interface Task25InterfaceOne{

    void methodInterfaceOne();
}

interface Task25InterfaceTwo{

    void methodInterfaceTwo();
}

public class Task25<T extends Task25InterfaceOne & Task25InterfaceTwo> {

    public <T extends Task25InterfaceOne> void methodOne(T t) {
        t.methodInterfaceOne();
    }

    public <T extends Task25InterfaceTwo> void methodTwo(T t) {
        t.methodInterfaceTwo();
    }

}

class Task25Satelite implements Task25InterfaceOne, Task25InterfaceTwo {

    @Override
    public void methodInterfaceOne() {
        System.out.println("methodInterfaceOne");
    }

    @Override
    public void methodInterfaceTwo() {
        System.out.println("methodInterfaceTwo");

    }

    public static void main(String[] args) {
        Task25<Task25Satelite> task25 = new Task25();
        Task25Satelite satelite = new Task25Satelite();
        task25.methodOne(satelite);
        task25.methodTwo(satelite);
    }
}
