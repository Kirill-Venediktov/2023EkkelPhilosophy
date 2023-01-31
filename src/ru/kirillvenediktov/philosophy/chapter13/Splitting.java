package ru.kirillvenediktov.philosophy.chapter13;

import java.util.Arrays;

public class Splitting {

    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forrest..." +
            "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void replace(String regex, String substitute) {
        System.out.println(knights.replaceAll(regex, substitute));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");

        split("the|you");

        replace("[aeiouyAEIUY]", "_");
    }
}
