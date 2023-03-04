package ru.kirillvenediktov.philosophy.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList {

    private File path;

    public SortedDirList(String path) {
        this.path = new File(path);
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public String[] list() {
        String[] list = path.list();
        assert list != null;
        Arrays.sort(list);
        return list;
    }

    public String[] list(String regex) {
        return path.list(new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                if (dir.isDirectory()) {
                    return pattern.matcher(name).find();
                }

                return false;
            }
        });
    }

    public static void main(String[] args) {
        SortedDirList dirList = new SortedDirList(
                "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter17\\.");
        System.out.println(Arrays.toString(dirList.list()));
        System.out.println(Arrays.toString(dirList.list("^M.+")));
    }
}
