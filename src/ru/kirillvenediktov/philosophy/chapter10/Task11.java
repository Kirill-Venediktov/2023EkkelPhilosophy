package ru.kirillvenediktov.philosophy.chapter10;

public class Task11 {

    private class Inner implements Task9Interface {

        @Override
        public void method() {
            System.out.println("method");
        }
    }

    public Task9Interface getTask9Interface() {
        return this.new Inner();
    }
}

class Task11Satelite {

    public static void main(String[] args) {
        Task11 task11 = new Task11();
        Task9Interface task9Interface = task11.getTask9Interface();
        task9Interface.method();
//        ((Task11.Inner)task9Interface).method();
//        Task9Interface task9Interface2 = task11.new Inner();
    }
}
