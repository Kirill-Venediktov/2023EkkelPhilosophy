package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task21 {

    private Map<String, Integer> words = new HashMap<>();

    public Map<String, Integer> countNumberOfWordEntries(List<String> stringList) {
        for (String word : stringList) {
            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                int i = words.get(word);
                i++;
                words.put(word, i);
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Task21 task21 = new Task21();
        Map<String, Integer> w = task21.countNumberOfWordEntries(
                new TextFile("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt", "\\W+"));
        System.out.println(w);
//
//        Set<String> words = new TreeSet<>(
//                new TextFile("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt", "\\W+"));
//        System.out.println(words);
    }

}
