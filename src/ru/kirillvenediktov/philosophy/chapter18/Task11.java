package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Task11 {

    public static LinkedList<String> getLinesLinkedList(String[] args) throws IOException {
        LinkedList<String> lines = new LinkedList<>();
        if (args.length != 0) {
            try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
                String s;
                while ((s = in.readLine()) != null) {
                    lines.add(s);
                }
            }
        } else {
            System.exit(0);
        }
        return lines;
    }


    public static void createTextFile(LinkedList<String> list, String path) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(path)) {
            String s;
            int lineCount = list.size();
            while ((s = list.pollLast()) != null)
                out.println(lineCount-- + ": " + s);
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedList<String> lines = getLinesLinkedList(args);
        createTextFile(lines,
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\task11.txt");
    }
}
