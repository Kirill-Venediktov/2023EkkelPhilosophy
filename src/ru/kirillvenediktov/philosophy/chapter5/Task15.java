package ru.kirillvenediktov.philosophy.chapter5;

public class Task15 {
    String s;
    {
        System.out.println("мутим мутки");
        s = "initialisation complete";
    }

    public Task15() {
        System.out.println("constructor, bitch");
    }

    public static void main(String[] args) {
        Task15 task15 = new Task15();
        System.out.println(task15.s);
    }
}
