package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class Task8 {

    public void method() throws MyException {
        throw new MyException("Exception text");
    }

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        try {
            task8.method();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
