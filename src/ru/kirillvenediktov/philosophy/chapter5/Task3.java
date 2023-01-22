package ru.kirillvenediktov.philosophy.chapter5;

public class Task3 {

    public Task3() {
        System.out.println("Привет, петухи");
    }

    public Task3(String string) {
        System.out.println(string);
        System.out.println("Привет, петухи");
    }


    public static void main(String[] args) {
        Task3 task3 = new Task3("added string");
    }
}
