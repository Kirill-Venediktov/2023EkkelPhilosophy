package ru.kirillvenediktov.philosophy.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {

    private static List<String> created = new ArrayList<>();

    private String s;

    private char c;

    private int id = 0;

    public CountedString(String str, char c) {
        this.s = str;
        this.c = c;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " char: " + c + " id: " + id +
                " hashCode(): " + hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString) o).s) &&
                ((Character) c).equals(((CountedString) o).c) &&
                id == ((CountedString) o).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + ((Character) c).hashCode();
        result = 37 * result + id;
        return result;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'c');
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up" + cstring);
            System.out.println(map.get(cstring));
        }
    }
}
