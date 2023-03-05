package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory;

import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.Event;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.GreenhouseControls;

public class VentilationOffFactory implements EventFactory {

    private GreenhouseControls gc;

    public VentilationOffFactory(GreenhouseControls gc) {
        this.gc = gc;
    }

    @Override
    public Event getNewEvent(long time) {
        return gc.new VentilationOff(time);
    }
}
