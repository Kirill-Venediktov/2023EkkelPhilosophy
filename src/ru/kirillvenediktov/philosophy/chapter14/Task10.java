package ru.kirillvenediktov.philosophy.chapter14;

public class Task10 {

    public static boolean checkChar(char[] chars) {
        return chars.getClass().getComponentType().isPrimitive();
    }

    public static void main(String[] args) {
        char[] chars = new char[4];
        System.out.println(checkChar(chars));
    }
}
