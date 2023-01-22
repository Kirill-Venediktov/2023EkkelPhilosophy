package ru.kirillvenediktov.philosophy.chapter4;

import java.util.Random;

class IntComparator {

    public void compare(int i1, int i2) {
        if (i1 > i2) {
            System.out.println(i1 + " greater then " + i2);
        } else if (i1 < i2) {
            System.out.println(i1 + " less then " + i2);
        } else {
            System.out.println(i1 + " equals " + i2);
        }
    }


}

public class Task2 {

    public static void main(String[] args) {
        Random random = new Random();
        IntComparator intComparator = new IntComparator();
        while (true) {
            intComparator.compare(random.nextInt(100), random.nextInt(100));
        }
    }
}
