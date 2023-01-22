package ru.kirillvenediktov.philosophy.chapter10;

public class Task10 {

    public Task9Interface getTask9Interface(boolean b) {
        Task9Interface task9Interface = null;
        if (b) {
            class Task9Satelite implements Task9Interface {

                @Override
                public void method() {
                    System.out.println("method one");
                }
            }
            task9Interface = new Task9Satelite();
        }
        return task9Interface;
    }

    public static void main(String[] args) {
        Task10 task10 = new Task10();
        task10.getTask9Interface(true).method();
        try {
            task10.getTask9Interface(false).method();
        } catch (NullPointerException e) {
            System.out.println("Здесь объект не создается");
        }

    }
}
