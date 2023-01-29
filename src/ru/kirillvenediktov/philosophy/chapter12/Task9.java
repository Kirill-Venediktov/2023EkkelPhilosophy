package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException2;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException3;

import java.util.Random;

public class Task9 {

    private Random random = new Random();

    public void method() throws MyException, MyException2, MyException3 {
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                throw new MyException("Exception text");
            case 1:
                throw new NullPointerException();
            case 2:
                throw new NullPointerException();
            default:
        }
    }
}

class Task9Satelite {

    public static void main(String[] args) {
        Task9 task9 = new Task9();
        try {
            task9.method();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("in block Finally");
        }
    }
}
