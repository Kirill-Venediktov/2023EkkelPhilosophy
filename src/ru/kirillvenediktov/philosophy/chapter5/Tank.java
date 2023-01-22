package ru.kirillvenediktov.philosophy.chapter5;

public class Tank {
    int volume = 0;

    public Tank(int volume) {
        this.volume = volume;
    }

    public void devastate() {
        volume = 0;
    }

    public void check() {
        System.out.println("в баке " + volume + " литров.");
    }

    protected void finalize() {
        if (volume != 0) {
            System.out.println("Error: volume");
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank(10);
        tank.check();
        tank.devastate();
        tank.finalize();
        tank = new Tank(12);
        tank.finalize();
    }
}
