package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory;

import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.Event;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.GreenhouseControls;

public class LightOffFactory implements EventFactory {

    private GreenhouseControls gc;

    public LightOffFactory(GreenhouseControls gc) {
        this.gc = gc;
    }

    @Override
    public Event getNewEvent(long time) {
        return gc.new LightOff(time);
    }
}
