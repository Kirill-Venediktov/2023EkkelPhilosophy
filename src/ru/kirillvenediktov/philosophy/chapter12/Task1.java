package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class Task1 {

    public static void main(String[] args) {
        try {
            throw new MyException("Excetion text");
        } catch (MyException e) {
            System.out.println("Catch block. Exception: " + e);
        } finally {
            System.out.println("Finally block");
        }
    }
}
