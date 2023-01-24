package ru.kirillvenediktov.philosophy.chapter10.greenhouse;

public class GreenhouseController {

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new VentilationOn(1000),
                gc.new VentilationOff(1200),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, events));
        if (args.length == 1) {
            gc.addEvent(
                    new GreenhouseControls.Terminate(Integer.valueOf(args[0]))
            );
        }
        gc.run();
    }
}

class Task25Controller {

    public static void main(String[] args) {
        Task25 task25 = new Task25();
        task25.addEvent(task25.new Bell(900));
        Event[] events = {
                task25.new ThermostatNight(0),
                task25.new LightOn(200),
                task25.new LightOff(400),
                task25.new WaterOn(600),
                task25.new WaterOff(800),
                task25.new VentilationOn(1000),
                task25.new VentilationOff(1200),
                task25.new ThermostatDay(1400),
                task25.new HydrationOn(1600),
                task25.new HydrationOff(1800)
        };
        task25.addEvent(task25.new Restart(2000, events));
        if (args.length == 1) {
            task25.addEvent(
                    new GreenhouseControls.Terminate(Integer.parseInt(args[0]))
            );
        }
        task25.run();
    }
}
