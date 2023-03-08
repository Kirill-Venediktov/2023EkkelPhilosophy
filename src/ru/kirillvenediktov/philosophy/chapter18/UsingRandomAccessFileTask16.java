package ru.kirillvenediktov.philosophy.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFileTask16 {

    static String file =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\rtestTask16.dat";

    static void display() throws IOException {
        try (RandomAccessFile rf = new RandomAccessFile(file, "r")) {
            System.out.println(rf.readDouble());
            System.out.println(rf.readUTF());
            System.out.println(rf.readByte());
            System.out.println(rf.readChar());
            System.out.println(rf.readBoolean());
            System.out.println(rf.readFloat());
            System.out.println(rf.readInt());
            System.out.println(rf.readShort());
            System.out.println(rf.readLong());
            System.out.println(rf.readUTF());
        }
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeDouble(3.14159);
        rf.writeUTF("That was pi");
        rf.writeByte((byte) 4);
        rf.writeChar((char) 548);
        rf.writeBoolean(true);
        rf.writeFloat(17f);
        rf.writeInt(111);
        rf.writeShort((short) 12);
        rf.writeLong(900L);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
    }
}