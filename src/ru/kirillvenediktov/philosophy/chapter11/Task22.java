package ru.kirillvenediktov.philosophy.chapter11;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task22 {

    private Set<WordStatisticCarrier> carriers = new HashSet<>();

    public Set<WordStatisticCarrier> countNumberOfWordEntries(List<String> stringList) {
        boolean isExist = false;
        for (String word : stringList) {
            for (WordStatisticCarrier carrier : carriers) {
                if (carrier.getWord().equals(word)) {
                    int i = carrier.getCount();
                    i++;
                    carrier.setCount(i);
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                carriers.add(new WordStatisticCarrier(word, 1));
            }
        }
        return carriers;
    }

    public static void main(String[] args) {
        Task22 task22 = new Task22();
        Set<WordStatisticCarrier> carriers = task22.countNumberOfWordEntries(
                new TextFile("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt", "\\W+")
        );
        System.out.println(carriers);
    }
}
