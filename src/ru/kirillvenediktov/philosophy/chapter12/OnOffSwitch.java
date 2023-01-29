package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.OnOffException1;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.OnOffException2;

import java.util.Random;

public class OnOffSwitch {

    private static Switch sw = new Switch();

    private static Random random = new Random();

    public static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {
        try {
            sw.on();
            int i = random.nextInt(2);
            if (i == 0) {
                throw new OnOffException1();
            }
            f();
            sw.off();
            throw new RuntimeException();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }

}
