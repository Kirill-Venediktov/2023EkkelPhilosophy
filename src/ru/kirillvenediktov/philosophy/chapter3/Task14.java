package ru.kirillvenediktov.philosophy.chapter3;

class StringComparator {

    public void compare(String string1, String string2) {
        System.out.println();
        System.out.println(string1 + " " + string2);
        System.out.println("string 1 > string 2: " + (string1.length() > string2.length()));
        System.out.println("string 1 < string 2: " + (string1.length() < string2.length()));
        System.out.println("string 1 >= string 2: " + (string1.length() >= string2.length()));
        System.out.println("string 1 <= string 2: " + (string1.length() <= string2.length()));
        System.out.println("string 1 == string 2: " + (string1 == string2));
        System.out.println("string 1 != string 2: " + (string1 != string2));
        System.out.println("string 1 equals string 2: " + string1.equals(string2));
    }
}

public class Task14 {

    public static void main(String[] args) {
        StringComparator comparator = new StringComparator();
        String first = "first";
        String second = "second";
        String third = "third";
        String fourth = "first";
        String fifth = new String("first");
        comparator.compare(first, second);
        comparator.compare(third, fourth);
        comparator.compare(first, fourth);
        comparator.compare(first, fifth);
        comparator.compare(second, second);

    }

}
