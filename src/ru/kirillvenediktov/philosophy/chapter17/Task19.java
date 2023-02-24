package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.List;

public class Task19 {

    public SimpleHashMap<String, Integer> countWords(String path) {
        SimpleHashMap<String, Integer> storage = new SimpleHashMap<>();
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
        Task19 task19 = new Task19();
        SimpleHashMap<String, Integer> storage = task19.countWords(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");
        System.out.println(storage);

    }
}
