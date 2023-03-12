package ru.kirillvenediktov.philosophy.chapter19;

import java.util.Random;

enum CartoonCharacterTask2 {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCHY, NUTTY, BOB;
    private static Random random = new Random(47);

    public static CartoonCharacterTask2 next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementationTask2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(CartoonCharacterTask2.next() + ", ");
        }
    }
}
