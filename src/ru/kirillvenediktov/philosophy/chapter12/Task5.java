package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class Task5 {

    public static void main(String[] args) {
        int count = 0;
        while (count < 5) {
            try {
                throw new MyException("Count < 5! ");
            } catch (MyException e) {
                e.printStackTrace();
                System.out.println("count = " + count);
            }
            count++;
        }
    }
}
