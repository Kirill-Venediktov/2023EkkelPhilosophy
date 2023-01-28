package ru.kirillvenediktov.philosophy.chapter8;

import java.util.Random;

public class RandomRodentGenerator {

    private static final int NUMBER_OF_TYPES = 5;

    Random random = new Random();
    Shared shared = new Shared();

    public Rodent next() {
        Rodent rodent = null;
        switch (random.nextInt(NUMBER_OF_TYPES)) {
            case 0:
                rodent = new Mouse(shared);
                break;
            case 1:
                rodent = new Rat(shared);
                break;
            case 2:
                rodent = new Hamster(shared);
                break;
            case 3:
                rodent = new Capybara(shared);
                break;
            case 4:
                rodent = new Chinchilla(shared);
        }
        return rodent;
    }
}
