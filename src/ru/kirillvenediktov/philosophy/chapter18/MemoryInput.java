package ru.kirillvenediktov.philosophy.chapter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("" +
                        "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\MemoryInput.java")
        );
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}

