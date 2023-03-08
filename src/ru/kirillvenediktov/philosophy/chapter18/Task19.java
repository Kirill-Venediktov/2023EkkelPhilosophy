package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.BinaryFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task19 {

    private final Map<Byte, Integer> countingMap = new HashMap<>();

    public void countBytes(byte[] bytes) {
        for (byte b : bytes) {
            countByte(b);
        }
    }

    private void countByte(byte b) {
        if (countingMap.containsKey(b)) {
            int count = countingMap.get(b);
            count++;
            countingMap.put(b, count);
        } else {
            countingMap.put(b, 1);
        }
    }

    public void clearMap() {
        countingMap.clear();
    }

    public void showNumberOfBytes() {
        System.out.println(countingMap);
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19();
        try {
            task19.countBytes(BinaryFile.read("C:\\ideaWorkspace\\2023EkkelPhilosophy\\test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        task19.showNumberOfBytes();
    }
}
