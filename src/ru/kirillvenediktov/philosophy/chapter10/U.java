package ru.kirillvenediktov.philosophy.chapter10;

import java.util.Arrays;

public interface U {

    void methodOne();

    void methodTwo();

    void methodThree();

}

class A {

    public U getU() {
        return new U() {

            @Override
            public void methodOne() {
                System.out.println("Method one");
            }

            @Override
            public void methodTwo() {
                System.out.println("Method two");
            }

            @Override
            public void methodThree() {
                System.out.println("Method three");
            }

            @Override
            public String toString() {
                return "$classname{}";
            }
        };
    }
}

class B {

    private U[] us = new U[20];

    private int next = 0;

    public U[] getUs() {
        return us;
    }

    public int getNext() {
        return next;
    }

    private boolean checkIsCrowded() {
        boolean isCrowded = false;
        if (next == us.length) {
            isCrowded = true;
        }
        return isCrowded;
    }


    public boolean addU(U u) {
        boolean isAdded = false;
        if (!checkIsCrowded()) {
            us[next++] = u;
            isAdded = true;
        }
        return isAdded;
    }

    public U removeU() {
        U u;
        if (checkIsCrowded() || (us[next] == null && next != 0)) {
            next--;
        }
        u = us[next];
        us[next] = null;
        return u;
    }

    public U removeU(int position) {
        U u = us[position];
        us[position] = null;
        return u;
    }

    public void iterateOver() {
        int i = 0;
        while (i < us.length) {
            if (us[i] == null) {
                i++;
                continue;
            }
            us[i].methodOne();
            us[i].methodTwo();
            us[i].methodThree();
            i++;
        }
    }

    public static void main(String[] args) {
        A[] as = new A[30];
        for (int i = 0; i < as.length; i++) {
            as[i] = new A();
        }
        B b = new B();
        for (A a : as) {
            b.addU(a.getU());
        }
        System.out.println(Arrays.toString(b.getUs()));

        b.iterateOver();

        System.out.println(b.removeU(2));

        System.out.println(Arrays.toString(b.getUs()));

        b.iterateOver();

        for (int i = 0; i < 11; i++) {
            b.removeU();
        }
        System.out.println(Arrays.toString(b.getUs()));

        for (int i = 0; i < 20; i++) {
            b.removeU();
        }
        System.out.println(Arrays.toString(b.getUs()));

        b.iterateOver();
    }
}