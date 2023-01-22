package ru.kirillvenediktov.philosophy.chapter10;

public class Task7 {
    private String stringField = "Hello";

    private void methodOne() {
        System.out.println("Method one");
    }

    public void methodTwo() {
        Task7.Inner inner = this.new Inner();
        inner.innerMethod();
    }

    class Inner {
        public void innerMethod() {
            stringField = "Changed by inner class";
            methodOne();
        }
    }

    public static void main(String[] args) {
        Task7 task7 = new Task7();
        task7.methodTwo();
        System.out.println(task7.stringField);
    }
}
