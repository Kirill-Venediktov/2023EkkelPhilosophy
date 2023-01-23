package ru.kirillvenediktov.philosophy.chapter9;

import java.util.Random;

interface FortuneGame {
    Random random = new Random();
    void makeThrow();
}

interface FortuneFactory {
    FortuneGame getFortuneGame();
}

class CoinGame implements FortuneGame {

    private CoinGame() {
    }

    @Override
    public void makeThrow() {
        int probabilityPercent = random.nextInt(99);
        if (probabilityPercent < 50) {
            System.out.println("Орел");
        } else if (probabilityPercent > 50) {
            System.out.println("Решка");
        } else {
            System.out.println("Ребро");
        }
    }

    public static FortuneFactory fortuneFactory = new FortuneFactory() {

        @Override
        public FortuneGame getFortuneGame() {
            return new CoinGame();
        }
    };

}

class DiceGame implements FortuneGame {

    private DiceGame() {
    }

    @Override
    public void makeThrow() {
        int throwingResult = random.nextInt(6) + 1;

        System.out.println(throwingResult);

    }

    public static FortuneFactory fortuneFactory = new FortuneFactory() {

        @Override
        public FortuneGame getFortuneGame() {
            return new DiceGame();
        }
    };

}

public class Task19 {

    public void playGame(FortuneFactory fortuneFactory, int iterations) {
        FortuneGame game = fortuneFactory.getFortuneGame();
        for (int i = 0; i < iterations; i++) {
            game.makeThrow();
        }
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19();
        System.out.println("Dice");
        task19.playGame(DiceGame.fortuneFactory, 20);
        System.out.println("Coin");
        task19.playGame(CoinGame.fortuneFactory, 20);
    }

}
