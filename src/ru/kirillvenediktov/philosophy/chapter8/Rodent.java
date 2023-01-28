package ru.kirillvenediktov.philosophy.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public interface Rodent {

    Characteristic characteristic = new Characteristic("Грызун");
    Description description = new Description("Общий класс");

    void gnaw();

    void rustle();

    void squeak();

}

class Characteristic {
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Создаем Characteristic " + s);
    }
}

class Description {
    private String s;

    public Description(String s) {
        this.s = s;
        System.out.println("Создаем Description " + s);
    }
}

class Mouse implements Rodent {

    Characteristic characteristic = new Characteristic("Мышь");
    Description description = new Description("Полевка");

    private Shared shared;

    public Mouse(Shared shared) {
        System.out.println("Mouse()");
        this.shared = shared;
        this.shared.addRef();
    }

    @Override
    public void gnaw() {
        System.out.println("Мышь грызет");
    }

    @Override
    public void rustle() {
        System.out.println("Мышь шуршит");
    }

    @Override
    public void squeak() {
        System.out.println("Мышь пищит");
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}

class Rat implements Rodent {

    Characteristic characteristic = new Characteristic("Крыса");
    Description description = new Description("Вредитель");

    private Shared shared;

    public Rat(Shared shared) {
        System.out.println("Rat()");
        this.shared = shared;
        this.shared.addRef();
    }

    @Override
    public void gnaw() {
        System.out.println("Крыса грызет");
    }

    @Override
    public void rustle() {
        System.out.println("Крыса шуршит");
    }

    @Override
    public void squeak() {
        System.out.println("Крыса пищит");
    }

    @Override
    public String toString() {
        return "Rat";
    }
}

class Hamster implements Rodent {

    Characteristic characteristic = new Characteristic("Хомяк");
    Description description = new Description("Милое создание");

    private Shared shared;

    public Hamster(Shared shared) {
        System.out.println("Hamster()");
        this.shared = shared;
        this.shared.addRef();
    }

    @Override
    public void gnaw() {
        System.out.println("Хомяк грызет");
    }

    @Override
    public void rustle() {
        System.out.println("Хомяк шуршит");
    }

    @Override
    public void squeak() {
        System.out.println("Хомяк пищит");
    }

    @Override
    public String toString() {
        return "Rat()";
    }
}

class Chinchilla implements Rodent {

    Characteristic characteristic = new Characteristic("Шиншилла");
    Description description = new Description("Домашняя зверушка");

    private Shared shared;

    public Chinchilla(Shared shared) {
        System.out.println("Chinchilla()");
        this.shared = shared;
        this.shared.addRef();
    }

    @Override
    public void gnaw() {
        System.out.println("Шиншилла грызет");
    }

    @Override
    public void rustle() {
        System.out.println("Шиншилла шуршит");
    }

    @Override
    public void squeak() {
        System.out.println("Шиншилла пищит");
    }

    @Override
    public String toString() {
        return "Chinchilla";
    }
}

class Capybara implements Rodent {

    Characteristic characteristic = new Characteristic("Капибара");
    Description description = new Description("Самый большой грызун");

    private Shared shared;

    public Capybara(Shared shared) {
        System.out.println("Capybara");
        this.shared = shared;
        this.shared.addRef();
    }

    @Override
    public void gnaw() {
        System.out.println("Капибара грызет");
    }

    @Override
    public void rustle() {
        System.out.println("Капибара шуршит");
    }

    @Override
    public void squeak() {
        System.out.println("Капибара пищит");
    }

    @Override
    public String toString() {
        return "Capybara";
    }
}

class Forrest {

    private static RandomRodentGenerator generator = new RandomRodentGenerator();

    public static void main(String[] args) {
        List<Rodent> rodents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rodents.add(generator.next());
        }
        Iterator<Rodent> iterator = rodents.iterator();
        while (iterator.hasNext()) {
            Rodent rodent = iterator.next();
            rodent.gnaw();
            rodent.rustle();
            rodent.squeak();
        }
        System.out.println(generator.shared.getRefcount());
    }

}
