package ru.kirillvenediktov.philosophy.chapter5;

public class Task10 {

    @Override
    public void finalize() {
        System.out.println("That's all, folks!");
    }


    public static void main(String[] args) {
        Task10 task10 = new Task10();
        task10.finalize();
    }

}
