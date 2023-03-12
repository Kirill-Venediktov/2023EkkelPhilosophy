package ru.kirillvenediktov.philosophy.chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrepChapter18Task26 {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        String encoding = System.getProperty("file.encoding");
        FileChannel fc = new FileInputStream(args[0]).getChannel();
        MappedByteBuffer mb = fc.map(FileChannel.MapMode.READ_ONLY, 0, new File(args[0]).length());
        String[] sa = Charset.forName(encoding).decode(mb).toString().split("\n");
        for (String line : sa) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
        }
        fc.close();

    }
}
