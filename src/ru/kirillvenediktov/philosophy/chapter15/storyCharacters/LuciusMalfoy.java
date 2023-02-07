package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class LuciusMalfoy extends StoryCharacter implements BadGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<LuciusMalfoy> {

        @Override
        public LuciusMalfoy create() {
            return new LuciusMalfoy();
        }
    }

    @Override
    public void killPeople() {
        System.out.println(this + " kill people!");
    }
}
