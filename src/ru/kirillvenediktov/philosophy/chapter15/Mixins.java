package ru.kirillvenediktov.philosophy.chapter15;

import java.util.Date;

interface TimeStamped {

    long getStamp();
}

class TimeStampedImpl implements TimeStamped {

    private final long timeStamp;

    public TimeStampedImpl() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {

    long getSerialNumber();
}

class SerialNumberedImpl implements SerialNumbered {

    private static long count = 1;

    private final long serialNumber = count++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {

    void set(String val);

    String get();
}

class BasicImpl implements Basic {

    private String value;

    @Override
    public void set(String val) {
        this.value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

interface Colored {

    String getColor();

    void setColor(String color);
}

class ColoredImpl implements Colored {

    private String color;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

class Mixin extends BasicImpl implements TimeStamped, SerialNumbered, Colored {

    private TimeStamped timeStamped = new TimeStampedImpl();

    private SerialNumbered serialNumbered = new SerialNumberedImpl();

    private Colored colored = new ColoredImpl();

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }

    @Override
    public String getColor() {
        return colored.getColor();
    }

    @Override
    public void setColor(String color) {
        colored.setColor(color);
    }
}

public class Mixins {

    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        mixin1.setColor("Brown");
        mixin2.setColor("Yellow");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " "
                + mixin1.getSerialNumber() + " " + mixin1.getColor());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " "
                + mixin2.getSerialNumber() + " " + mixin2.getColor());
    }

}
