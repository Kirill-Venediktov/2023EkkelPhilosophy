package ru.kirillvenediktov.philosophy.chapter18;

import ru.kirillvenediktov.philosophy.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3Task1 {

    public static void main(String[] args) {
        File path = new File(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\.");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {

                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    if (dir.isDirectory()){
                        String text = TextFile.read(dir.getAbsolutePath() + "\\" + name);
                        return pattern.matcher(text).find();
                    }
                    return false;
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
