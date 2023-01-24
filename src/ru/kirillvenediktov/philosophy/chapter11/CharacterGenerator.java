package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CharacterGenerator {

    private int count = 0;
    private static OfficeCharacter[] characters = OfficeCharacter.values();

    public OfficeCharacter next() {
        OfficeCharacter character;
        character = characters[count];
        if (++count == characters.length) {
            count = 0;
        }
        return character;
    }

    public OfficeCharacter[] fillArray(OfficeCharacter[] characters) {
        for (int i = 0; i < characters.length; i++) {
            characters[i] = next();
        }
        return characters;
    }

    public Collection<OfficeCharacter> fillCollection(Collection<OfficeCharacter> characters, int limit) {
        for (int i = 0; i < limit; i++) {
            characters.add(next());
        }
        return characters;
    }
}

class Task4 {

    public static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {
        CharacterGenerator generator = new CharacterGenerator();

        System.out.println("Array[]");
        System.out.println(Arrays.toString(generator.fillArray(new OfficeCharacter[ARRAY_SIZE])));
        System.out.println("ArrayList: ");
        System.out.println(generator.fillCollection(new ArrayList<>(), ARRAY_SIZE));
        System.out.println("LinkedList: ");
        System.out.println(generator.fillCollection(new LinkedList<>(), ARRAY_SIZE));
        System.out.println("HashSet: ");
        System.out.println(generator.fillCollection(new HashSet<>(), ARRAY_SIZE));
        System.out.println("LinkedHashSet: ");
        System.out.println(generator.fillCollection(new LinkedHashSet<>(), ARRAY_SIZE));
        System.out.println("TreeSet: ");
        System.out.println(generator.fillCollection(new TreeSet<>(), ARRAY_SIZE));

    }
}
