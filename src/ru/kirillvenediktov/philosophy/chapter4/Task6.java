package ru.kirillvenediktov.philosophy.chapter4;

import ru.kirillvenediktov.philosophy.exceptions.InvalidParameterException;

class IfElse2 {
    public int test(int testval, int begin, int end) {
        if (begin > end) {
            throw new InvalidParameterException("begin greater then end");
        }
        if (testval > begin && testval < end) {
            return 1;
        } else if (testval > end || testval < begin) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Task6 {

    public static void main(String[] args) {
        IfElse2 ifElse2 = new IfElse2();
        System.out.println(ifElse2.test(5, 3,6));
        System.out.println(ifElse2.test(1, 3,6));
        System.out.println(ifElse2.test(7, 3,6));
        System.out.println(ifElse2.test(4, 6,3));
    }
}
