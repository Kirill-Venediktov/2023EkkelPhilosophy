package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        String link =
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\Data.txt";
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(link)))) {
            out.writeDouble(3.14159);
            out.writeUTF("That was pi");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
        }

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(link)))) {
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        }
    }
}
