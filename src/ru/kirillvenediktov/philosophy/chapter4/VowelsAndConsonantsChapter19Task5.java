package ru.kirillvenediktov.philosophy.chapter4;

import java.util.Random;

enum Letter {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('y', 'w'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z');

    char[] letters;

    Letter(char... chars) {
        this.letters = chars;
    }

    public static String getType(char c) {
        String type = null;
        for (Letter letter : Letter.values()) {
            for (int i = 0; i < letter.letters.length; i++) {
                if (c == letter.letters[i]) {
                    type = letter.name();
                    break;
                }
            }
        }
        return type;
    }

}

public class VowelsAndConsonantsChapter19Task5 {


    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.println((char) c + ", " + c + ": ");
            System.out.println(Letter.getType((char) c));
        }
    }
}
