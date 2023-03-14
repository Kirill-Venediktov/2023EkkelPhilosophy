package ru.kirillvenediktov.philosophy.chapter18;

import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Task33 {

    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(Task33.class);
        int value = prefs.getInt("Base directory", 0);
        System.out.println(value);
        System.out.print("Введите новое значение: ");
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextInt();
        prefs.putInt("Base directory", value);
        for (String key : prefs.keys()) {
            System.out.println(key + ": " + prefs.get(key, null));
        }
    }
}
