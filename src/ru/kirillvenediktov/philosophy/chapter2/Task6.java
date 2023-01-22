package ru.kirillvenediktov.philosophy.chapter2;

class StringHandler {

    int storage(String s) {
        return s.length() * 2;
    }

}

public class Task6 {

    public static void main(String[] args) {
        StringHandler stringHandler = new StringHandler();
        System.out.println(stringHandler.storage("Hello world"));
    }

}
