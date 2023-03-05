package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.Directory;

import java.io.File;
import java.util.Iterator;

public class Task4 {

    public static void main(String[] args) {
        Directory.TreeInfo treeInfo = Directory.walk(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter17\\",
                "^M.+");
        long size = 0;
        Iterator<File> iterator = treeInfo.iterator();
        while (iterator.hasNext()) {
            size += iterator.next().length();
        }

        System.out.println("Total size = " + size);
    }
}
