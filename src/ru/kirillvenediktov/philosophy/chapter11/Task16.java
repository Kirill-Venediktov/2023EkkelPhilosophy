package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task16 {

    private Map<Character, Integer> numberOfVowels = new HashMap<>();


    private static final Set<Character> vowels = new HashSet<>(
            Arrays.asList('A', 'E', 'I', 'O', 'Y', 'a', 'e', 'o', 'u', 'y'));

    private void resetMap() {
        numberOfVowels = new HashMap<>();
        numberOfVowels.put('A',0);
        numberOfVowels.put('E',0);
        numberOfVowels.put('I',0);
        numberOfVowels.put('O',0);
        numberOfVowels.put('Y',0);
        numberOfVowels.put('a',0);
        numberOfVowels.put('e',0);
        numberOfVowels.put('o',0);
        numberOfVowels.put('u',0);
        numberOfVowels.put('y',0);
    }

    private int getNumberOfVowelsInWord(String word) {
        int count = 0;
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (vowels.contains(letter)) {
                count++;
            }
        }
        return count;
    }

    private String[] splitText(String text) {
        return text.split(" ");
    }

    public int getNumberOfVowelsInText(String text) {
        int total = 0;
        for (String string : splitText(text)) {
            total += getNumberOfVowelsInWord(string);
        }
        return total;
    }

    public static void main(String[] args) {
        Task16 task16 = new Task16();
        String testString = "total number";
        System.out.println("Количество гласных: " + task16.getNumberOfVowelsInText(testString));

        System.out.println("Количество гласных из файла: "
                + task16.getNumberOfVowelsInText(
                        TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt")));

//        TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");

    }

}
