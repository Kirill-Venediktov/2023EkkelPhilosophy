package ru.kirillvenediktov.philosophy.chapter3;

class SpeedCalculator {

    public double calculate(double distance, double time) {
        return distance / time;
    }
}

public class Task4 {

    public static void main(String[] args) {
        double distance = 894.23;
        double time = 8.11;
        SpeedCalculator speedCalculator = new SpeedCalculator();
        double speed = speedCalculator.calculate(distance, time);
        System.out.println("speed = " + speed);
    }
}
