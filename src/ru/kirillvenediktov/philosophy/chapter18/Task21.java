package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task21 {

    public static void main(String[] args) throws IOException {
        File file = new File(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\Task21.java");
        BufferedInputStream inFile =
                new BufferedInputStream(new
                        FileInputStream(file));
        System.setIn(inFile);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
        }
    }
}
