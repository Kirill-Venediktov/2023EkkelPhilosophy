package ru.kirillvenediktov.philosophy.chapter7;

class Cleanser {

    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent {

    private Cleanser cleanser = new Cleanser();

    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.append(" Detergent.scrub()");
        cleanser.scrub();
    }

    public void foam() {
        cleanser.append(" foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Проверяем базовый класс");
        Cleanser.main(args);
    }

    @Override
    public String toString() {
        return cleanser.toString();
    }
}

class Sanitizer {

    private Detergent detergent = new Detergent();

    public void dilute() {
        detergent.dilute();
    }

    public void apply() {
        detergent.apply();
    }

    public void foam() {
        detergent.append(" foam()");
    }

    public void scrub() {
        detergent.append(" Sanitizer.scrub()");
        detergent.scrub();
    }

    public void sterilize() {
        detergent.append(" sterilize()");
    }

    @Override
    public String toString() {
        return detergent.toString();
    }

    public static void main(String[] args) {
        Sanitizer x = new Sanitizer();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        System.out.println(x);
    }
}
