package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {

    static String file =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\FileOutputShortcut.java"
        )));
        try (PrintWriter out = new PrintWriter(file)) {
            String s;
            int lineCount = 1;
            while ((s = in.readLine()) != null)
                out.println(lineCount++ + ": " + s);

        }
        System.out.print(BufferedInputFile.read(file));

    }
}
