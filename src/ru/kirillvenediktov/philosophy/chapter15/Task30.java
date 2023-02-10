package ru.kirillvenediktov.philosophy.chapter15;

public class Task30 {

    public static void main(String[] args) {
        Holder<Integer> integerHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        Holder<Character> characterHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();

        integerHolder.setValue(5);
        doubleHolder.setValue(5.3);
        characterHolder.setValue('c');
        floatHolder.setValue(7.5f);
        byteHolder.setValue((byte) 3);
        shortHolder.setValue((short) 5);

        System.out.println(integerHolder.getValue());
        System.out.println(doubleHolder.getValue());
        System.out.println(characterHolder.getValue());
        System.out.println(floatHolder.getValue());
        System.out.println(byteHolder.getValue());
        System.out.println(shortHolder.getValue());
    }
}
