package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListFeaturesInteger {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> integers = random.ints(
                7, 0, 20).boxed().collect(Collectors.toList());
        System.out.println("1:" + integers);
        int i1 = 16;
        integers.add(i1);
        System.out.println("2: " + integers);
        System.out.println("3: " + integers.contains(i1));
        integers.remove((Integer)i1);
        int i2 = integers.get(2);
        System.out.println("4: " + i2 + " " + integers.indexOf(i2));
        int i3 = 12;
        System.out.println("5: " + integers.indexOf(i3));
        System.out.println("6: " + integers.remove((Integer)i3));
        System.out.println("7: " + integers.remove((Integer)i2));
        System.out.println("8: " + integers);
        integers.add(3, 10);
        System.out.println("9: " + integers);
        List<Integer> sub = integers.subList(1,4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + integers.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки: " + sub);
        System.out.println("11: " + integers.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + integers.containsAll(sub));
        List<Integer> copy = new ArrayList<>(integers);
        sub = Arrays.asList(integers.get(1), integers.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(integers);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, 12);
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + integers.isEmpty());
        integers.clear();
        System.out.println("19: " + integers);
        System.out.println("20: " + integers.isEmpty());
        integers.addAll(random.ints(
                4, 0, 20).boxed().collect(Collectors.toList()));
        System.out.println("21: " + integers);
        Object[] o = integers.toArray();
        System.out.println("22: " + o[3]);
        Integer[] ints = integers.toArray(new Integer[0]);
        System.out.println("23: " + ints[3]);

    }
}
