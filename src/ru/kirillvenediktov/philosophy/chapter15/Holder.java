package ru.kirillvenediktov.philosophy.chapter15;

import java.util.Objects;

public class Holder<T> {

    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holder<?> holder = (Holder<?>) o;
        return Objects.equals(value, holder.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
