package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFileTask18 extends ArrayList<String> {

    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()));
        try {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) throws IOException {
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        );
        try {
            out.print(text);
        } finally {
            out.close();
        }
    }

    public TextFileTask18(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFileTask18(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public void write(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        );
        try {
            for (String item : this)
                out.println(item);
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        String file = null;
        try {
            file = read("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\TextFile.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            write("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test.txt", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextFileTask18 text = null;
        try {
            text = new TextFileTask18("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            text.write("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        TreeSet<String> words = null;
        try {
            words = new TreeSet<>
                    (new TextFileTask18("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\TextFile.java", "\\W+"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(words.headSet("a"));

    }
}
