package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListFeaturesString {

    public static void main(String[] args) {
        Random random = new Random();
        CharacterGenerator generator = new CharacterGenerator();
        List<String> strings = (ArrayList<String>) generator.fillCollectionOfStrings(new ArrayList<>(), 7);
        System.out.println("1:" + strings);
        String string1 = generator.next().toString();
        strings.add(string1);
        System.out.println("2: " + strings);
        System.out.println("3: " + strings.contains(string1));
        strings.remove(string1);
        String string2 = strings.get(2);
        System.out.println("4: " + string2 + " " + strings.indexOf(string2));
        String string3 = generator.next().toString();
        System.out.println("5: " + strings.indexOf(string3));
        System.out.println("6: " + strings.remove(string3));
        System.out.println("7: " + strings.remove(string2));
        System.out.println("8: " + strings);
        strings.add(3, generator.next().toString());
        System.out.println("9: " + strings);
        List<String> sub = strings.subList(1,4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + strings.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки: " + sub);
        System.out.println("11: " + strings.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + strings.containsAll(sub));
        List<String> copy = new ArrayList<>(strings);
        sub = Arrays.asList(strings.get(1), strings.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(strings);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, generator.next().toString());
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + strings.isEmpty());
        strings.clear();
        System.out.println("19: " + strings);
        System.out.println("20: " + strings.isEmpty());
        strings.addAll(generator.fillCollectionOfStrings(new ArrayList<>(), 4));
        System.out.println("21: " + strings);
        Object[] o = strings.toArray();
        System.out.println("22: " + o[3]);
        String[] ints = strings.toArray(new String[0]);
        System.out.println("23: " + ints[3]);

    }
}
