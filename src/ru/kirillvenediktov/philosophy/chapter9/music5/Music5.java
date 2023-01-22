package ru.kirillvenediktov.philosophy.chapter9.music5;

import ru.kirillvenediktov.philosophy.chapter8.music3.Note;

import java.util.Random;

abstract class Instrument {

    abstract void adjust();

}

interface Playable {
    void play(Note note);
}

class Wind extends Instrument implements Playable{

    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Wind");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion extends Instrument implements Playable {

    @Override
    public void play(Note note) {
        System.out.println("Percussion.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Percussion");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed extends Instrument implements Playable {

    @Override
    public void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind implements Playable {

    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }

    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {

    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Woodwind");
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}

class Drums extends Percussion {

    @Override
    public void play(Note note) {
        System.out.println("Drums.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Drums");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class RandomInstrumentGenerator {

    private static final int NUMBER_OF_INSTRUMENTS = 6;

    private Random random = new Random();

    public Playable next() {
        Playable instrument = null;
        switch (random.nextInt(NUMBER_OF_INSTRUMENTS)) {
            case 0:
                instrument = new Wind();
                break;
            case 1:
                instrument = new Percussion();
                break;
            case 2:
                instrument = new Drums();
                break;
            case 3:
                instrument = new Brass();
                break;
            case 4:
                instrument = new Stringed();
                break;
            case 5:
                instrument = new Woodwind();
        }
        return instrument;
    }
}

public class Music5 {

    private static RandomInstrumentGenerator generator = new RandomInstrumentGenerator();

    public static void tune(Playable playable) {
        playable.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Playable[] playables) {
        for (Playable playable : playables) {
            tune(playable);
        }
    }

    public static void main(String[] args) {

        Playable[] instruments = new Playable[10];
        for (int i = 0; i < instruments.length; i++) {
            instruments[i] = generator.next();
        }
        tuneAll(instruments);
        System.out.println(instruments[0]);
    }

}
