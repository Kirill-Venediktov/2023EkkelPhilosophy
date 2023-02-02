package ru.kirillvenediktov.philosophy.chapter13;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static final String POEM =
            "Twas brilling, and slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves, \n" +
                    "And the mome raths outgrabe. \n\n" +
                    "Beware the Jabberwock, my son, \n" +
                    "The jaws that bite, the Claws that catch. \n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
//        Matcher matcher =
//                Pattern.compile(("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")).matcher(POEM);
        Matcher matcher = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").matcher(POEM);
//        while (matcher.find()) {
//            for (int j = 0; j < matcher.groupCount(); j++) {
//                System.out.print("[" + matcher.group(j) + "]");
//            }
//            System.out.println();
//        }
        while (matcher.find()) {
            for (int j = 0; j < matcher.groupCount(); j++) {
                System.out.print("[" + matcher.group(j) + "]");
                words.add(matcher.group(j));
            }
            System.out.println();
        }
        System.out.println(words);
        System.out.println(words.size());

    }

}
