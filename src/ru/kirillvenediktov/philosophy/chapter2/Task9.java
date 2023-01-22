package ru.kirillvenediktov.philosophy.chapter2;

class PrimitiveCarrier {
    private int a;
    private int b;
    private Integer integer;

    public PrimitiveCarrier(int a) {
        this.a = 5;
        this.b = a;
        this.integer = a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}

class PrimitiveHandler {

    public void showCondition(PrimitiveCarrier carrier) {
        System.out.println(carrier.getA());
        System.out.println(carrier.getB());
        System.out.println(carrier.getInteger());
    }

    public void changeCondition(PrimitiveCarrier carrier) {
        carrier.setA(carrier.getA() + 1);
    }
}

public class Task9 {

    public static void main(String[] args) {
        PrimitiveCarrier primitiveCarrier = new PrimitiveCarrier(5);
        PrimitiveHandler handler = new PrimitiveHandler();
        handler.showCondition(primitiveCarrier);
        handler.changeCondition(primitiveCarrier);
        System.out.println("after changing: ");
        handler.showCondition(primitiveCarrier);

    }
}
