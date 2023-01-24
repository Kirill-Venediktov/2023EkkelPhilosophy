package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.List;

public class Gerbil {

    private int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil number: " + gerbilNumber);
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil(i));
        }
        for (Gerbil gerbil : gerbils) {
            gerbil.hop();
        }
    }
}
