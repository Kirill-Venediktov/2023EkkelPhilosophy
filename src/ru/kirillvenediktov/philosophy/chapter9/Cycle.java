package ru.kirillvenediktov.philosophy.chapter9;

public interface Cycle {

    void ride();
}

interface CycleFactory {

    Cycle getCycle();
}

class Unicycle implements Cycle {

    private Unicycle() {
    }

    @Override
    public void ride() {
        System.out.println("Unicycle rides");
    }

    public static CycleFactory cycleFactory = new CycleFactory() {

        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {

    private Bicycle() {
    }

    @Override
    public void ride() {
        System.out.println("Bicycle rides");
    }

    public static CycleFactory cycleFactory = new CycleFactory() {

        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {

    private Tricycle() {
    }

    @Override
    public void ride() {
        System.out.println("Tricycle rides");
    }

    public static CycleFactory cycleFactory = new CycleFactory() {

        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

class Biking {

    public void goBiking(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        Biking biking = new Biking();
        biking.goBiking(Unicycle.cycleFactory);
        biking.goBiking(Bicycle.cycleFactory);
        biking.goBiking(Tricycle.cycleFactory);
    }
}



