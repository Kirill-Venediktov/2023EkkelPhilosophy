package ru.kirillvenediktov.philosophy.chapter13;

public class Task6 {

    int anInt = 5;
    long aLong = 2000L;
    float aFloat = 25.36F;
    double aDouble = 55.66;

    @Override
    public String toString() {
        return String.format("i = %d\nl = %d\nf = %.4g\nd = %.4g\n", anInt, aLong, aFloat, aDouble);
    }

    public static void main(String[] args) {
        Task6 task6 = new Task6();
        System.out.println(task6.toString());
    }
}
