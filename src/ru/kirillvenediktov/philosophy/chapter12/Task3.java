package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter8.Rodent;

public class Task3 {

    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[2];
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catch block. Exception: " + e);
            e.printStackTrace();
        }

    }
}
