package ru.kirillvenediktov.philosophy.chapter8;

class Cycle {
    private String name = "Cycle";

    public void travel() {
        System.out.println(toString() + " rides");
    }

    public int getNumberOfWheels() {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

}

class Unicycle extends Cycle {

    private String name = "Unicycle";
    private int numberOfWheels = 1;

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String toString() {
        return name;
    }

    public void balance() {
        System.out.println("Balancing on unicycle");
    }

}

class Bicycle extends Cycle {

    private String name = "Bicycle";
    private int numberOfWheels = 2;

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String toString() {
        return name;
    }

    public void balance() {
        System.out.println("Balancing on bicycle");
    }
}

class Tricycle extends Cycle {

    private String name = "Tricycle";
    private int numberOfWheels = 3;

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Biking {

    public void ride(Cycle cycle) {
        cycle.travel();
        System.out.println(cycle.getNumberOfWheels());
    }

    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new Unicycle();
        cycles[1] = new Bicycle();
        cycles[2] = new Tricycle();
                
//        Biking biking = new Biking();
//        Cycle unicycle = new Unicycle();
//        Cycle bicycle = new Bicycle();
//        Cycle tricycle = new Tricycle();
//        biking.ride(unicycle);
//        biking.ride(bicycle);
//        biking.ride(tricycle);
    }
}
