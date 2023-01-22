package ru.kirillvenediktov.philosophy.chapter9;

public interface Cycle {

    void ride();
}

interface CycleFactory {

    Cycle getCycle();
}

class Unicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Unicycle rides");
    }
}

class Bicycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Bicycle rides");
    }
}

class Tricycle implements Cycle {

    @Override
    public void ride() {
        System.out.println("Tricycle rides");
    }
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

class Biking {

    public void goBiking(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        Biking biking = new Biking();
        biking.goBiking(new UnicycleFactory());
        biking.goBiking(new BicycleFactory());
        biking.goBiking(new TricycleFactory());
    }
}



