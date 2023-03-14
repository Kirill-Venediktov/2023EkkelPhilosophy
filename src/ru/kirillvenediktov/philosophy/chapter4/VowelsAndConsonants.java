package ru.kirillvenediktov.philosophy.chapter4;

import java.util.Random;

public class VowelsAndConsonants {
    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.println((char) c + ", " + c + ": ");
            switch (c) {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    System.out.println("гласная");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Условно гласная");
                    break;
                default:
                    System.out.println("согласная");
            }
        }
    }
}
