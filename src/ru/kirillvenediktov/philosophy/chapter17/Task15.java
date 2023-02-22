package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.List;
import java.util.Map;

public class Task15 {

    public Map<String, Integer> countWords(String path) {
        Map<String,Integer> storage = new SlowMap<>();
        List<String> words = new TextFile(path, "[.,?!\\n\\s]+");
        System.out.println(words);

        for (String word : words) {
            if (storage.containsKey(word)) {
                int count = storage.get(word);
                storage.put(word, ++count);
            } else {
                storage.put(word, 1);
            }
        }

        return storage;
    }

    public static void main(String[] args) {
        Task15 task15 = new Task15();
        Map<String, Integer> storage = task15.countWords(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");
        System.out.println(storage);

    }
}
