package ru.kirillvenediktov.philosophy.chapter10;

public interface Task9Interface {
    void method();
}

class Task9Class {

    public Task9Interface getTask9Interface() {
        class Task9Satelite implements Task9Interface {

            @Override
            public void method() {
                System.out.println("method one");
            }
        }
        return new Task9Satelite();
    }

    public static void main(String[] args) {
        Task9Class task9Class = new Task9Class();
        task9Class.getTask9Interface().method();
    }
}
