package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutputTask14 {

    static String file =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\BasicFileOutput.out";

    public static void writeWithBuffer(BufferedReader in) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));) {
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null)
                out.println(lineCount++ + ": " + s);
        }
    }

    public static void writeWithoutBuffer(BufferedReader in) throws IOException {
        try (PrintWriter out = new PrintWriter(file)) {
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null)
                out.println(lineCount++ + ": " + s);
        }
    }

    public static void main(String[] args) throws IOException {
        Long start = System.nanoTime();
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BasicFileOutput.java"
        )));
        writeWithBuffer(in);
        Long finish = System.nanoTime();
        long bufTime = finish - start;

        start = System.nanoTime();
        BufferedReader in2 = new BufferedReader(new StringReader(BufferedInputFile.read(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BasicFileOutput.java"
        )));
        writeWithoutBuffer(in2);
        finish = System.nanoTime();
        long withoutBuffTime = finish - start;
        System.out.println("with buffer : " + bufTime + " ns");
        System.out.println("without buffer: " + withoutBuffTime + " ns");

    }
}
