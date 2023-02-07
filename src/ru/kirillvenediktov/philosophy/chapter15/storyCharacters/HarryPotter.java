package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class HarryPotter extends StoryCharacter implements GoodGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<HarryPotter> {

        @Override
        public HarryPotter create() {
            return new HarryPotter();
        }
    }

    @Override
    public void savePeople() {
        System.out.println(this + " save people!");
    }
}
