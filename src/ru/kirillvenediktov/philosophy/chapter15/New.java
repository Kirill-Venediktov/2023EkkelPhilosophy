package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter15.storyCharacters.StoryCharacter;
import ru.kirillvenediktov.philosophy.chapter15.storyCharacters.StoryCharactersGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class New {

    public static Map<String, StoryCharacter> map() {
        return new HashMap<>();
    }

    public static List<StoryCharacter> list() {
        return new ArrayList<>();
    }

    public static LinkedList<StoryCharacter> lList() {
        return new LinkedList<>();
    }

    public static Set<StoryCharacter> set() {
        return new HashSet<>();
    }

    public static Queue<StoryCharacter> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        StoryCharactersGenerator generator = new StoryCharactersGenerator();
        Map<String, StoryCharacter> storyCharacterMap = New.map();
        List<StoryCharacter> storyCharacterList = New.list();
        LinkedList<StoryCharacter> storyCharacterLinkedList = New.lList();
        Set<StoryCharacter> storyCharacterSet = New.set();
        Queue<StoryCharacter> storyCharacterQueue = New.queue();

        StoryCharacter character = generator.next();
        storyCharacterMap.put(character.toString(), character);
        storyCharacterList.add(generator.next());
        storyCharacterLinkedList.add(generator.next());
        storyCharacterSet.add(generator.next());
        storyCharacterQueue.add(generator.next());

        System.out.println(storyCharacterMap);
        System.out.println(storyCharacterList);
        System.out.println(storyCharacterLinkedList);
        System.out.println(storyCharacterSet);
        System.out.println(storyCharacterQueue);

    }
}
