package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory;

import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.Event;

public interface EventFactory {

    Event getNewEvent(long time);
}
