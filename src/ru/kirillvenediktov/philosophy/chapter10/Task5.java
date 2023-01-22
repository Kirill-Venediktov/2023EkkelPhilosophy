package ru.kirillvenediktov.philosophy.chapter10;

public class Task5 {
    class Inner {

    }
}

class Task5Satelite {

    public static void main(String[] args) {
        Task5 task5 = new Task5();
//        Task5.Inner inner2 = new Task5.Inner();
        Task5.Inner inner = task5.new Inner();
    }
}
