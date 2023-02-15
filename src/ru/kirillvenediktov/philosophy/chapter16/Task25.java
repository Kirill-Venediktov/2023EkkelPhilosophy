package ru.kirillvenediktov.philosophy.chapter16;

import java.util.ArrayList;
import java.util.Arrays;

public class Task25 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        System.out.println(ints.getClass());
        System.out.println(Arrays.toString(ints));
        System.out.println(ints[4]);
        int[] ints2 = Arrays.copyOf(ints, 8);
        ints2[5] = 6;
        ints2[6] = 7;
        ints2[7] = 8;
        System.out.println(Arrays.toString(ints2));
        int[] slice = Arrays.copyOfRange(ints2, 2, 4);
        System.out.println(Arrays.toString(slice));
        System.out.println("-----------");
        MyList<Integer> list2 = new MyList<>();
        for (int i = 0; i < ints2.length; i++) {
            list2.add(ints2[i]);
        }
        System.out.println(list2.getClass());
        System.out.println(list2.getReversed());
    }
}

class MyList<T> extends ArrayList {

    public <T> ArrayList<T> getReversed() {
        ArrayList<T> reversed = new ArrayList();
        for (int i = (this.size() - 1); i >= 0; i--) {
            reversed.add((T) this.get(i));
        }
        return reversed;
    }
}
