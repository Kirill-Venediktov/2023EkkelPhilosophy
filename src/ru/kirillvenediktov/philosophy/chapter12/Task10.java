package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException2;

public class Task10 {

    public void f() throws RuntimeException {
        try {
            g();
        } catch (MyException e) {
            throw new RuntimeException();
        }
    }

    public void g() throws MyException {
        throw new MyException("Exception text");
    }

    public static void main(String[] args) {
        Task10 task10 = new Task10();
        try {
            task10.f();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
