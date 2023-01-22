package ru.kirillvenediktov.philosophy.chapter8;

class Meal {

    public Meal() {
        System.out.println("Meal()");
    }
}

class Bread {

    public Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {

    public Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {

    public Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Pickle {

    public Pickle() {
        System.out.println("Pickle()");
    }
}

class Lunch extends Meal {

    public Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {

    public PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

interface FastFood {

    void beFat();

    void beTasty();
}

public class Sandwich extends PortableLunch implements FastFood {

    private Bread bread = new Bread();

    private Cheese cheese = new Cheese();

    private Lettuce lettuce = new Lettuce();

    private Pickle pickle = new Pickle();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    @Override
    public void beFat() {
        System.out.println("Im so fat!");
    }

    @Override
    public void beTasty() {
        System.out.println("Im so tasty!!");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        sandwich.beFat();
        sandwich.beTasty();

    }
}
