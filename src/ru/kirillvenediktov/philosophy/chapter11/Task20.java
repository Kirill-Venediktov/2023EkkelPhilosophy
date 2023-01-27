package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task20 {

    private Map<Character, Integer> vowels = new HashMap<>();

    private void resetMap() {
        vowels = new HashMap<>();
        vowels.put('A',0);
        vowels.put('E',0);
        vowels.put('I',0);
        vowels.put('O',0);
        vowels.put('Y',0);
        vowels.put('a',0);
        vowels.put('e',0);
        vowels.put('o',0);
        vowels.put('u',0);
        vowels.put('y',0);
    }

    private void getNumberOfVowelsInWord(String word) {
        Set<Character> characters = vowels.keySet();
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (characters.contains(letter)) {
                int i = vowels.get(letter);
                i++;
                vowels.put(letter, i);
            }
        }
    }

    private String[] splitText(String text) {
        return text.split(" ");
    }

    public Map<Character, Integer> getNumberOfVowelsInText(String text) {
        resetMap();
        for (String string : splitText(text)) {
            getNumberOfVowelsInWord(string);
        }
        return vowels;
    }

    public static void main(String[] args) {
        Task20 task16 = new Task20();
        String testString = "total number";
        System.out.println("Количество гласных: " + task16.getNumberOfVowelsInText(testString));

        System.out.println("Количество гласных из файла: "
                + task16.getNumberOfVowelsInText(
                        TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt")));

//        TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");

    }

}
