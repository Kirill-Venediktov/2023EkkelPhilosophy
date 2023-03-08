package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.BinaryFile;
import ru.kirillvenediktov.philosophy.util.Directory;

import java.io.File;
import java.io.IOException;

public class Task20 {

    public static void main(String[] args) throws IOException {
        for (File file : Directory.walk(".",".*\\.class").files){
            byte[] bytes = BinaryFile.read(file);
            for (int i = 0; i < 4; i++)
                System.out.println(Integer.toHexString(bytes[i] & 0xff).toUpperCase());
        }
    }
}
