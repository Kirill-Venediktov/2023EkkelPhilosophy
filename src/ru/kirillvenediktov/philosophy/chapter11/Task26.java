package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Map;

public class Task26 {

    public static void main(String[] args) {
        Task25 task25 = new Task25();
        Map<String, ArrayList<Integer>> words = task25.getMapOfWords(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt");
        for (Map.Entry<String, ArrayList<Integer>> entry : words.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
