package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Gerbil {

    private final int gerbilNumber;
    private static Random random = new Random();

    private String name;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandomName() {
        OfficeCharacter[] names = OfficeCharacter.values();
        setName(names[random.nextInt(names.length)].name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerbil gerbil = (Gerbil) o;
        return gerbilNumber == gerbil.gerbilNumber &&
                Objects.equals(name, gerbil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gerbilNumber, name);
    }

    @Override
    public String toString() {
        return "Gerbil{" +
                "gerbilNumber=" + gerbilNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public void hop() {
        System.out.println("Gerbil number: " + gerbilNumber);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil(i));
        }
        Iterator<Gerbil> iterator = gerbils.iterator();
        while (iterator.hasNext()) {
            iterator.next().hop();
        }

    }
}
