package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class Task4 {

    public static void main(String[] args) {
        try{
            throw new MyException("Text");
        } catch (MyException e) {
            System.out.println("Catch block. Exception: " + e);
            e.showMessage();
        }
    }
}
