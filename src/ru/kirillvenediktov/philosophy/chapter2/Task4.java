package ru.kirillvenediktov.philosophy.chapter2;

class DataOnly {
    private int i;
    private double d;
    private boolean b;

    public void setI(int i) {
        this.i = i;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public void showFields(){
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
    }
}

public class Task4 {
    public static void main(String[] args) {
        DataOnly dataOnly  = new DataOnly();
        dataOnly.showFields();
        dataOnly.setI(5);
        dataOnly.setB(true);
        dataOnly.setD(4.55);
        dataOnly.showFields();
    }
}
