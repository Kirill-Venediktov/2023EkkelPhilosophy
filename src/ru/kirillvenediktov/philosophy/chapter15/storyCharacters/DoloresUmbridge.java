package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class DoloresUmbridge extends StoryCharacter implements BadGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<DoloresUmbridge> {

        @Override
        public DoloresUmbridge create() {
            return new DoloresUmbridge();
        }
    }

    @Override
    public void killPeople() {
        System.out.println(this + " kill people!");
    }
}
