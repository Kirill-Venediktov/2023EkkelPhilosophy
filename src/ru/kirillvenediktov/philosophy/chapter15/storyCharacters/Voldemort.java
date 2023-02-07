package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class Voldemort extends StoryCharacter implements BadGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<Voldemort> {

        @Override
        public Voldemort create() {
            return new Voldemort();
        }
    }

    @Override
    public void killPeople() {
        System.out.println(this + " kill people!");
    }
}
