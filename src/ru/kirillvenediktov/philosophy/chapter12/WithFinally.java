package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.OnOffException1;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.OnOffException2;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
            throw new RuntimeException();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
