package ru.kirillvenediktov.philosophy.chapter6_1;

public class Task5 {

    public int a = 1;
    int b = 3;
    protected int c = 4;
    private int d = 5;

    public void f() {
        System.out.println("public");
    }

    void g() {
        System.out.println("package private");
    }

    protected void h() {
        System.out.println("protected");
    }

    private void k() {
        System.out.println("private");
    }
}
