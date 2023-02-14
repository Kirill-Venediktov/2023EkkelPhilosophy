package ru.kirillvenediktov.philosophy.chapter16;

public class BerylliumSphere {

    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}
