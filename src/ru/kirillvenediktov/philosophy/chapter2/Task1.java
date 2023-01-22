package ru.kirillvenediktov.philosophy.chapter2;

public class Task1 {

    private int a;
    private char b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }

    public static void main(String[] args) {

        Task1 task1 = new Task1();
        System.out.println("int a: " + task1.a);
        System.out.println("char b: " + task1.b);

    }
}
