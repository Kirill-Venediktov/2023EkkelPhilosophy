package ru.kirillvenediktov.philosophy.chapter7;

class Task13Satelite {

    public void testMethod() {
        System.out.println("TestMethod");
    }

    public void testMethod(int i) {
        System.out.println("TestMethod. int = " + i);
    }

    public void testMethod(String s) {
        System.out.println("TestMethod. String = " + s);
    }

}

public class Task13 extends Task13Satelite {

    public void testMethod(char c) {
        System.out.println("TestMethod. Char = " + c);
    }

    public static void main(String[] args) {
        Task13 task = new Task13();
        task.testMethod();
        task.testMethod(19);
        task.testMethod("love");
        task.testMethod('2');
    }
}
