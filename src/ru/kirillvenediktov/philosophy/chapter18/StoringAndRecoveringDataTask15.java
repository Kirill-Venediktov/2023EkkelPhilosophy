package ru.kirillvenediktov.philosophy.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringDataTask15 {

    public static void main(String[] args) throws IOException {
        String link =
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\DataTask15.txt";
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(link)))) {
            out.writeDouble(3.14159);
            out.writeUTF("That was pi");
            out.writeByte((byte) 4);
            out.writeChar((char) 548);
            out.writeBoolean(true);
            out.writeFloat(17f);
            out.writeInt(111);
            out.writeShort((short) 12);
            out.writeLong(900L);
        }

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(link)))) {
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readByte());
            System.out.println(in.readChar());
            System.out.println(in.readBoolean());
            System.out.println(in.readFloat());
            System.out.println(in.readInt());
            System.out.println(in.readShort());
            System.out.println(in.readLong());
        }
    }
}
