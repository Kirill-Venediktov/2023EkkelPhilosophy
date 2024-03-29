package ru.kirillvenediktov.philosophy.chapter19;

import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCHY, NUTTY, BOB;

    private Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc);
    }
}
