package ru.kirillvenediktov.philosophy.chapter10;

public interface Task20 {
    void method();
    class Inner {
        void methodOfClass(){
            System.out.println("Hello!");
        }
    }
}

class Task20Satelite implements Task20 {

    @Override
    public void method() {
        System.out.println("Realisation of interface method");
    }

    public static void main(String[] args) {
        Task20.Inner inner = new Inner();
        inner.methodOfClass();
    }
}

class Task20Test {

    public static void main(String[] args) {
        Task20.Inner inner = new Task20.Inner();
        inner.methodOfClass();
    }
}


