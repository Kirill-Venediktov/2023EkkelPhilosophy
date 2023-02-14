package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generator;

public class Task13 {

    public static void main(String[] args) {
        Generator<Character> generator = new CountingGenerator.Character();

        char[] buf = new char[10];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = generator.next();
        }

        String s = new String(buf);
        System.out.println(s);
    }
}
