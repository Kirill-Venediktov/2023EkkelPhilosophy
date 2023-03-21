package ru.kirillvenediktov.philosophy.chapter21;

public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
