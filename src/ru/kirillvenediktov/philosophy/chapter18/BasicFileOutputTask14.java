package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutputTask14 {
    static String file =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\BasicFileOutput.out";

    public static void bufferedWrite(BufferedReader in) throws IOException {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));) {
            int lineCount = 1;
            String s;
            while((s = in.readLine())!= null)
                out.println(lineCount++ + ": " + s);
        }
    }

    public static void nonBufferedWrite(DataInputStream in) throws IOException {
        try(PrintWriter out = new PrintWriter(file)) {
            int lineCount = 1;
            String s;
            while((s = in.readLine())!= null)
                out.println(lineCount++ + ": " + s);
        }
    }


    public static void main(String[] args) throws IOException {
        Long start =  System.nanoTime();
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BasicFileOutput.java"
        )));
        bufferedWrite(in);
        Long finish = System.nanoTime();
        long bufTime = finish - start;

        start = System.nanoTime();
        DataInputStream dis = new DataInputStream()
        StringReader sr = new StringReader(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\BasicFileOutput.java");
        nonBufferedWrite(sr);





        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));) {
            int lineCount = 1;
            String s;
            while((s = in.readLine())!= null)
                out.println(lineCount++ + ": " + s);
        }
        System.out.print(BufferedInputFile.read(file));
    }
}
