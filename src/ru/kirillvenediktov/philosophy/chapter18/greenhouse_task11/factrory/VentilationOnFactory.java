package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory;

import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.Event;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.GreenhouseControls;

public class VentilationOnFactory implements EventFactory {

    private GreenhouseControls gc;

    public VentilationOnFactory(GreenhouseControls gc) {
        this.gc = gc;
    }

    @Override
    public Event getNewEvent(long time) {
        return gc.new VentilationOn(time);
    }
}
