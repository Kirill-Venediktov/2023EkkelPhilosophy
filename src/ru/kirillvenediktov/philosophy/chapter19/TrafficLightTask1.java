package ru.kirillvenediktov.philosophy.chapter19;

import static ru.kirillvenediktov.philosophy.chapter19.Signal.GREEN;
import static ru.kirillvenediktov.philosophy.chapter19.Signal.YELLOW;
import static ru.kirillvenediktov.philosophy.chapter19.Signal.RED;

public class TrafficLightTask1 {
    Signal color = RED;
    public void change() {
        switch (color) {
            case RED: color = GREEN;
                break;
            case GREEN: color = YELLOW;
                break;
            case YELLOW: color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLightTask1 t = new TrafficLightTask1();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}