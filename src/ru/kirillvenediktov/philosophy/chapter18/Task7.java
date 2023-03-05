package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Task7 {

    public static LinkedList<String> getLinesLinkedList(String filename) throws IOException {
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = in.readLine()) != null) {
                lines.add(s);
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<String> lines = getLinesLinkedList(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BufferedInputFile.java");
        while (!lines.isEmpty()) {
            System.out.println(lines.pollLast());
        }
    }
}
