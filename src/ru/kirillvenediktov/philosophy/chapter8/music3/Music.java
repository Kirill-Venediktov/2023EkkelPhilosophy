package ru.kirillvenediktov.philosophy.chapter8.music3;

import java.util.Random;

class Instrument {

    void play(Note note) {
        System.out.println("Instrument.play() " + note);
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }

    @Override
    public String toString() {
        return "Instrument";
    }
}

class Wind extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Percussion.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed extends Instrument {

    @Override
    void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {

    @Override
    void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }

    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {

    @Override
    void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Woodwind");
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}

class Drums extends Percussion {

    @Override
    void play(Note note) {
        System.out.println("Drums.play() " + note);
    }

    @Override
    void adjust() {
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

    public Instrument next() {
        Instrument instrument = null;
        switch (random.nextInt(NUMBER_OF_INSTRUMENTS)){
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

public class Music {

    private static RandomInstrumentGenerator generator = new RandomInstrumentGenerator();

    public static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {

        Instrument[] instruments = new Instrument[10];
        for (int i = 0; i < instruments.length; i++) {
            instruments[i] = generator.next();
        }
        tuneAll(instruments);
        System.out.println(instruments[0]);
    }

}
