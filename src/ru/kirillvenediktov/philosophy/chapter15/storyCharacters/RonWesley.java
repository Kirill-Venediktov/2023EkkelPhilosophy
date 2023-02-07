package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class RonWesley extends StoryCharacter implements GoodGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<RonWesley> {

        @Override
        public RonWesley create() {
            return new RonWesley();
        }
    }

    @Override
    public void savePeople() {
        System.out.println(this + " save people!");
    }

}
