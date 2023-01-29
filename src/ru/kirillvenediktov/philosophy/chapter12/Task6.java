package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException2;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException3;

public class Task6 {

    public static void main(String[] args) {
        try {
            throw new MyException2();
        } catch (MyException2 e) {
            e.printStackTrace();
            e.getMessage();
        }

        try {
            throw new MyException3();
        } catch (MyException3 e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
