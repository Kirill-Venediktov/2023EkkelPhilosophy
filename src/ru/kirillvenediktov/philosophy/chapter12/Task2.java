package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter8.Rodent;

public class Task2 {

    public static void main(String[] args) {
        Rodent rodent = null;
        try {
            rodent.squeak();
        } catch (NullPointerException e) {
            System.out.println("Catch block. Exception: " + e);
        }

    }
}
