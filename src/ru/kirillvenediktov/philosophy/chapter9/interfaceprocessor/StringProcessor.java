package ru.kirillvenediktov.philosophy.chapter9.interfaceprocessor;

import java.util.Arrays;

public abstract class StringProcessor implements Processor {

    public static String s = "If she weighs as a duck, shes made of wood";
    public static String s2 = "Жопа полная, ребята";

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args) {
        Apply.process(new Anagram(), s2);
    }
}

class Anagram extends StringProcessor {

    @Override
    public Object process(Object input) {
        if (!input.getClass().equals(String.class)) {
            throw new IllegalArgumentException("Not String!");
        }
        char[] chars = ((String) input).toCharArray();
        if (chars.length > 1) {
            char buf1;
            char buf2;
            for (int i = 1; i + 2 < chars.length + 1; i += 2) {
                buf1 = chars[i];
                buf2 = chars[i - 1];
                chars[i] = buf2;
                chars[i - 1] = buf1;
            }
        }
        return Arrays.toString(chars);
    }
}
