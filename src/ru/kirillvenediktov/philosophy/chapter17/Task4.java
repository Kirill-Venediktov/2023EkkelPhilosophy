package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.util.Arrays;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                TextFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt").split(" "));
        System.out.println(words);
    }
}
