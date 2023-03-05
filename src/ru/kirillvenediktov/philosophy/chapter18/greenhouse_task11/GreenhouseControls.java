package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11;

import java.util.Iterator;
import java.util.List;

public class GreenhouseControls extends Controller {

    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Свет включен";
        }
    }

    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Свет выключен";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Полив включен";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Полив выключен";
        }
    }

    private boolean ventilation = false;

    public class VentilationOn extends Event {

        public VentilationOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            ventilation = true;
        }

        @Override
        public String toString() {
            return "Вентиляция включена";
        }
    }

    public class VentilationOff extends Event {

        public VentilationOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            ventilation = false;
        }

        @Override
        public String toString() {
            return "Вентиляция выключена";
        }
    }

    private String thermostat = "День";

    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Ночь";
        }

        @Override
        public String toString() {
            return "Термостат использует ночной режим";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "День";
        }

        @Override
        public String toString() {
            return "Термостат использует дневной режим";
        }
    }

    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Бам!";
        }
    }

    public class Restart extends Event {

        private List<Event> eventList;

        public Restart(long delayTime, List<Event> eventList) {
            super(delayTime);
            this.eventList = eventList;
            Iterator<Event> iterator = eventList.iterator();
            while (iterator.hasNext()) {
                addEvent(iterator.next());
            }
        }

        @Override
        public void action() {
            for (Event event : eventList) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Перезапуск системы";
        }
    }

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Отключение";
        }
    }

}

class Task25 extends GreenhouseControls {

    private boolean hydration = false;

    public class HydrationOn extends Event {

        public HydrationOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            hydration = true;
        }

        @Override
        public String toString() {
            return "Увлажнение включено";
        }
    }

    public class HydrationOff extends Event {

        public HydrationOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            hydration = false;
        }

        @Override
        public String toString() {
            return "Увлажнение выключено";
        }
    }

}
