package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

import ru.kirillvenediktov.philosophy.chapter11.CharacterGenerator;
import ru.kirillvenediktov.philosophy.chapter14.factory.Factory;
import ru.kirillvenediktov.philosophy.chapter15.coffee.Coffee;
import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StoryCharactersGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

    static List<Factory<? extends StoryCharacter>> storyCharactersFactories = new ArrayList<>();

    static {
        storyCharactersFactories.add(new HarryPotter.Factory());
        storyCharactersFactories.add(new RonWesley.Factory());
        storyCharactersFactories.add(new GermioneGrainger.Factory());
        storyCharactersFactories.add(new Voldemort.Factory());
        storyCharactersFactories.add(new LuciusMalfoy.Factory());
        storyCharactersFactories.add(new DoloresUmbridge.Factory());
    }

    private static Random random = new Random();

    private int size = 0;

    public StoryCharactersGenerator() {
    }

    public StoryCharactersGenerator(int size) {
        this.size = size;
    }

    @Override
    public StoryCharacter next() {
        return storyCharactersFactories.get(random.nextInt(storyCharactersFactories.size())).create();
    }

    class StoryCharacterIterator implements Iterator<StoryCharacter> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacter next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new StoryCharacterIterator();
    }

    public static void main(String[] args) {

        StoryCharactersGenerator generator = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        for (StoryCharacter c : new StoryCharactersGenerator(5)) {
            System.out.println(c);
        }
    }
}

