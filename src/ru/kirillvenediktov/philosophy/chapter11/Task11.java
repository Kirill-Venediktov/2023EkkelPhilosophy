package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task11 {

    public static final int ARRAY_SIZE = 20;

    public void showElementOfCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CharacterGenerator generator = new CharacterGenerator();

        List<OfficeCharacter> arrayList =(ArrayList<OfficeCharacter>) generator
                .fillCollection(new ArrayList<>(), ARRAY_SIZE);
        List<OfficeCharacter> linkedList =(LinkedList<OfficeCharacter>) generator
                .fillCollection(new LinkedList<>(), ARRAY_SIZE);
        Set<OfficeCharacter> hashSet = (HashSet<OfficeCharacter>) generator.fillCollection(new HashSet<>(), ARRAY_SIZE);
        Set<OfficeCharacter> linkedHashSet = (LinkedHashSet<OfficeCharacter>) generator
                .fillCollection(new LinkedHashSet<>(), ARRAY_SIZE);
        Set<OfficeCharacter> treeSet = (TreeSet<OfficeCharacter>) generator
                .fillCollection(new TreeSet<>(), ARRAY_SIZE);

        Task11 task11 = new Task11();
        task11.showElementOfCollection(arrayList);
        task11.showElementOfCollection(linkedList);
        task11.showElementOfCollection(hashSet);
        task11.showElementOfCollection(linkedHashSet);
        task11.showElementOfCollection(treeSet);

    }
}
