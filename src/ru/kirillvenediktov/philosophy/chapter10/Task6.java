package ru.kirillvenediktov.philosophy.chapter10;

import ru.kirillvenediktov.philosophy.chapter10_1.Task6Interface;

public class Task6 {

    protected class Inner implements Task6Interface {

        @Override
        public void methodOne() {
            System.out.println("Method one");
        }
    }
}
