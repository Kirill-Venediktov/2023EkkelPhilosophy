package ru.kirillvenediktov.philosophy.chapter8;

import java.util.Random;

class AlertStatus {
    public void alert() {

    }
}

class LowAlertStatus extends AlertStatus {

    @Override
    public void alert() {
        System.out.println("Low alert status");
    }
}

class ElevatedAlertStatus extends AlertStatus {

    @Override
    public void alert() {
        System.out.println("Elevated alert status");
    }
}

class HighAlertStatus extends AlertStatus {

    @Override
    public void alert() {
        System.out.println("High alert status");
    }
}

public class Starship {
    Random random = new Random();
    private AlertStatus status = new LowAlertStatus();
    public void changeStatus() {
        switch (random.nextInt(3)) {
            case 0:
                status = new LowAlertStatus();
                break;
            case 1:
                status = new ElevatedAlertStatus();
                break;
            case 2:
                status = new HighAlertStatus();
        }
    }
    public void reportStatus() {
        status.alert();
    }

}

class Space {

    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.reportStatus();
        starship.changeStatus();
        starship.reportStatus();
        starship.changeStatus();
        starship.reportStatus();
    }
}
