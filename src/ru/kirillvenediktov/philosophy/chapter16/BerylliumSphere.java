package ru.kirillvenediktov.philosophy.chapter16;

import java.util.Objects;

public class BerylliumSphere implements Comparable<BerylliumSphere>{

    private static long counter;

    private final long id = counter++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerylliumSphere that = (BerylliumSphere) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        return (Long.compare(id, o.id));
    }
}
