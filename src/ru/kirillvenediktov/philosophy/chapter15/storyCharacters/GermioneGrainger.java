package ru.kirillvenediktov.philosophy.chapter15.storyCharacters;

public class GermioneGrainger extends StoryCharacter implements GoodGuy {

    public static class Factory
            implements ru.kirillvenediktov.philosophy.chapter14.factory.Factory<GermioneGrainger> {

        @Override
        public GermioneGrainger create() {
            return new GermioneGrainger();
        }
    }

    @Override
    public void savePeople() {
        System.out.println(this + " save people!");
    }
}
