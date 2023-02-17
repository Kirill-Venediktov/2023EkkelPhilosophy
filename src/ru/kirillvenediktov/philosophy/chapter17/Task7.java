package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.Countries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task7 {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Countries.names(10));
        List<String> linkedList = new LinkedList<>(Countries.names(10));

        Iterator<String> arrIt = arrayList.iterator();
        Iterator<String> linkIt = linkedList.iterator();

        System.out.println("arrayList");
        while (arrIt.hasNext()){
            System.out.print(arrIt.next() + " ");
        }
        System.out.println();
        System.out.println("linkedList");
        while (linkIt.hasNext()) {
            System.out.print(linkIt.next() + " ");
        }
        System.out.println("----ADDING--------");

        ListIterator<String> lia = arrayList.listIterator();
        ListIterator<String> lil = linkedList.listIterator();

        while(lil.hasNext()) {
            if (lia.hasNext()) {
                lil.add(lia.next());
                lil.next();
            }
        }

        System.out.println(linkedList);

        System.out.println("---Reverse ADDING----");
        lia = arrayList.listIterator(arrayList.size());
        lil = linkedList.listIterator();

        while (lil.hasNext()){
            if (lia.hasPrevious()) {
                lil.add(lia.previous());
                lil.next();
            } else {
                break;
            }
        }
        System.out.println(linkedList);

    }
}
