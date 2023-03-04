package ru.kirillvenediktov.philosophy.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList3Task3 {

    public static void main(String[] args) {
        File path = new File(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter17\\");
        long size = 0;
        if (args.length == 0) {
            size = path.length();
        } else {
           File[] list = path.listFiles(new FilenameFilter() {

                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
           for (int i = 0; i < list.length; i++) {
               size += list[i].length();
           }

        }
        System.out.println("files size = " + size);
    }
}
