package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.HashMap;
import java.util.Map;

public class Task17 {

    private final Map<Character, Integer> countingMap = new HashMap<>();

    public void countSigns(String s) {
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            countChar(c);
        }
    }

    private void countChar(char c) {
        if (countingMap.containsKey(c)) {
            int count = countingMap.get(c);
            count++;
            countingMap.put(c, count);
        } else {
            countingMap.put(c, 1);
        }
    }

    public void clearMap() {
        countingMap.clear();
    }

    public void showNumberOfChars() {
        System.out.println(countingMap);
    }

    public static void main(String[] args) {
        Task17 task17 = new Task17();
        task17.countSigns(TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt"));
        task17.showNumberOfChars();
    }
}
