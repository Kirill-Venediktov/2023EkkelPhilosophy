package ru.kirillvenediktov.philosophy.chapter2;

class AllTheColorsOfTheRainbow {
    int anIntegerRepresentingColors;

    void changeTheHueOfTheColor(int newHue) {
        anIntegerRepresentingColors = newHue;
    }
}

public class Task11 {
    public static void main(String[] args) {
        AllTheColorsOfTheRainbow colors = new AllTheColorsOfTheRainbow();
        colors.anIntegerRepresentingColors = 5;
        System.out.println(colors.anIntegerRepresentingColors);
        colors.changeTheHueOfTheColor(77);
        System.out.println(colors.anIntegerRepresentingColors);
    }
}
