package ru.kirillvenediktov.philosophy.chapter9.task16;

import java.util.Random;

public class RandomChars {

    private static final int NUMBER_OF_LETTERS = 26;
    private static final char CHAR_SHIFT = 'a';

    private Random random = new Random();
    public char next() {
        return (char)(random.nextInt(NUMBER_OF_LETTERS) + CHAR_SHIFT);
    }
}


