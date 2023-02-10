package ru.kirillvenediktov.philosophy.chapter15;

public abstract class Task34<T extends Task34<T>> {

    abstract <T extends Task34<T>> T methodOne(T t);

    public <T extends Task34<T>> T methodTwo(T t) {
        return methodOne(t);
    }
}

class Task34Satelite extends Task34 {

    @Override
    Task34 methodOne(Task34 task34) {
        return task34;
    }

    public static void main(String[] args) {
        Task34Satelite satelite = new Task34Satelite();
        System.out.println(satelite.methodOne(satelite));
        System.out.println(satelite.methodTwo(satelite));
    }
}
