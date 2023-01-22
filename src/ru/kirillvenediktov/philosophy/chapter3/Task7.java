package ru.kirillvenediktov.philosophy.chapter3;

import java.util.Random;

class CoinSimulator {

    private int side = 0;

    private Random random;

    public CoinSimulator() {
        random = new Random();
    }

    public void simulate() {
        side = random.nextInt(100);
        System.out.println("выпало число = " + side);
        if (side < 50) {
            System.out.println("Орел!");
        } else if (side == 50) {
            System.out.println("Ребро!");
        } else {
            System.out.println("Решка!");
        }
    }
}

public class Task7 {

    public static void main(String[] args) {
        CoinSimulator simulator = new CoinSimulator();
        for (int i = 0; i < 50; i++) {
            simulator.simulate();
        }
    }
}
