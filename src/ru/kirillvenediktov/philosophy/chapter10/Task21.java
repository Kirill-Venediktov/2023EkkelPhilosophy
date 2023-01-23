package ru.kirillvenediktov.philosophy.chapter10;

public interface Task21 {

    int methodOne(int a);

    int methodTwo(int a);

    class Inner {

        static void innerMethod(Task21 task21, int a, int b) {
            System.out.println(task21.methodOne(a));
            System.out.println(task21.methodTwo(b));
        }
    }
}

class Task21Satelite implements Task21 {


    @Override
    public int methodOne(int a) {
        return a + 200;
    }

    @Override
    public int methodTwo(int a) {
        return a * 100;
    }

    public static void main(String[] args) {
        Task21 task21 = new Task21Satelite();
        Task21.Inner.innerMethod(task21, 5, 25);
    }
}
