package ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11;

import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.BellFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.LightOffFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.LightOnFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.ThermostatDayFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.ThermostatNightFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.VentilationOffFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.VentilationOnFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.WaterOffFactory;
import ru.kirillvenediktov.philosophy.chapter18.greenhouse_task11.factrory.WaterOnFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreenhouseController {

    public static Map<String, Long> readEvents(String filename) throws IOException {
        Map<String, Long> events = new HashMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] strings = s.split("[()]");
                events.put(strings[0], Long.valueOf(strings[1]));
            }
        }

        return events;
    }

    public static Event makeEvent(Map.Entry<String, Long> entry, GreenhouseControls gc) {

        switch (entry.getKey()) {
            case ("ThermostatNight"):
                return new ThermostatNightFactory(gc).getNewEvent(entry.getValue());
            case ("ThermostatDay"):
                return new ThermostatDayFactory(gc).getNewEvent(entry.getValue());
            case ("LightOn"):
                return new LightOnFactory(gc).getNewEvent(entry.getValue());
            case ("LightOff"):
                return new LightOffFactory(gc).getNewEvent(entry.getValue());
            case ("WaterOn"):
                return new WaterOnFactory(gc).getNewEvent(entry.getValue());
            case ("WaterOff"):
                return new WaterOffFactory(gc).getNewEvent(entry.getValue());
            case ("VentilationOn"):
                return new VentilationOnFactory(gc).getNewEvent(entry.getValue());
            case ("VentilationOff"):
                return new VentilationOffFactory(gc).getNewEvent(entry.getValue());
            case ("Bell"):
                return new BellFactory(gc).getNewEvent(entry.getValue());
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        List<Event> events = new ArrayList<>();
        gc.addEvent(gc.new Bell(900));
        try {
            for (Map.Entry<String, Long> entry : readEvents(
                    "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\greenhouse_task11\\1.txt")
                    .entrySet()) {
                events.add(makeEvent(entry, gc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        gc.addEvent(gc.new Restart(2000, events));
        if (args.length == 1) {
            gc.addEvent(
                    new GreenhouseControls.Terminate(Integer.valueOf(args[0]))
            );
        }
        gc.run();
    }
}

