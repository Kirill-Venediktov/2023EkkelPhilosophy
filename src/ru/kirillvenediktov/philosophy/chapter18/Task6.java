package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.ProcessFiles;

import java.io.File;

public class Task6 {

    private static final long MODIFICATION_TIME = 1676358000000L;

    public static void main(String[] args) {
        ProcessFiles processFiles = new ProcessFiles(new ProcessFiles.Strategy() {

            @Override
            public void process(File file) {
                if (file.lastModified() > MODIFICATION_TIME) {
                    System.out.println(file + " last modified: " + file.lastModified());
                }
            }
        }, "java");
        processFiles.start(args);
    }
}
