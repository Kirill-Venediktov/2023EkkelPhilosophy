package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.HoHumException;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.VeryImportantException;

public class LostMassage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMassage lm = new LostMassage();
            try {
                lm.f();
            } catch (VeryImportantException e) {
                e.printStackTrace();
            } finally {
                try {
                    lm.dispose();
                } catch (HoHumException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        throw new MyException("My exception text");
                    } catch (MyException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
