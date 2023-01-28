package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Task25 {

    public Map<String, ArrayList<Integer>> getMapOfWords(String path) {
        Map<String, ArrayList<Integer>> words = new LinkedHashMap<>();
        List<String> wordlist = new TextFile(path, "\\W+");
        for (String word : wordlist) {
            words.put(word, new ArrayList<>(Collections.singletonList(wordlist.indexOf(word))));
        }
        return words;
    }

    public static void main(String[] args) {

        Task25 task25 = new Task25();
        Map<String, ArrayList<Integer>> words = task25.getMapOfWords(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");

        System.out.println(words);

    }
}
