package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutputTask13 {
    static String file =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\BasicFileOutputTask13.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new BufferedReader(new StringReader(BufferedInputFile.read(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BasicFileOutputTask13.java"
        ))));

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            String s;
            while((s = lnr.readLine())!= null)
                out.println(lnr.getLineNumber() + ": " + s);
        }
        System.out.print(BufferedInputFile.read(file));
    }
}
