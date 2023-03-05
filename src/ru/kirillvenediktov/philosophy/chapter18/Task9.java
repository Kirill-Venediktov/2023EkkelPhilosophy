package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Task9 {

    public static LinkedList<String> getLinesLinkedList(String[] args) throws IOException {
        LinkedList<String> lines = new LinkedList<>();
        if (args.length != 0) {
            try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
                String s;
                while ((s = in.readLine()) != null) {
                    lines.add(s.toUpperCase());
                }
            }
        } else {
            System.exit(0);
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<String> lines = getLinesLinkedList(args);
        while (!lines.isEmpty()) {
            System.out.println(lines.pollLast());
        }
    }
}
