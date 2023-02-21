package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.List;

public class Task13 {

    public AssociativeArray<String, Integer> countWords(String path) {
        AssociativeArray<String, Integer> storage = new AssociativeArray<>(1000);
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
        Task13 task13 = new Task13();
        AssociativeArray<String, Integer> storage = task13.countWords(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");
        System.out.println(storage);

    }
}
