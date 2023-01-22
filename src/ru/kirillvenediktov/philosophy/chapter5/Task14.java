package ru.kirillvenediktov.philosophy.chapter5;

class StaticTestUnit{
    static String staticString = "static string";
    static int staticInt;
    static {
        staticInt = 7;
    }

    public static void staticMethod() {
        System.out.println(staticString + " " + staticInt);
    }
}

public class Task14 {

    public static void main(String[] args) {
        StaticTestUnit.staticMethod();
    }
}
