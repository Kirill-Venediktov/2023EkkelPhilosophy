package ru.kirillvenediktov.philosophy.chapter3;

public class Task3 {

    static void changeFloat(FloatCarrier carrier) {
        carrier.setTestFloat(666F);
    }

    public static void main(String[] args) {
        FloatCarrier carrier = new FloatCarrier();
        carrier.setTestFloat(11F);
        System.out.println("float = " + carrier.getTestFloat());
        changeFloat(carrier);
        System.out.println("float = " + carrier.getTestFloat());
    }
}
